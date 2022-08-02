package com.flipkart.dao;
import com.flipkart.bean.User;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.utils.DBUtils;
import com.flipkart.bean.Professor;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.app.CRSApplication.connection;

public class AdminDaoImpl implements AdminDaoInterface {
    Connection connection = DBUtils.getConnection();

    private PreparedStatement statement = null;
    public void addUser(User user){
        try{
            String query = "insert into user(userid,role,name,password) values (?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUserID());
            statement.setString(2,user.getRole());
            statement.setString(3,user.getName());
            statement.setString(4,user.getPassword());

            int row = statement.executeUpdate();
            System.out.println("User added at: "+row);

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void addProfessor(Professor professor){
        this.addUser(professor);
        statement = null;
        try{
            String query = "insert into Professor(professorId,department,Designation) values (?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1,professor.getUserID());
            statement.setString(2,professor.getDepartment());
            statement.setString(3,professor.getDesignation());
            int row = statement.executeUpdate();
            System.out.println("Professor Added at: "+row);
        }
        catch(SQLException se){
            System.out.println("Add Professor Failed.");
        }

    }
    public void approveStudent(String userId){
        String query = "update student set isApproved = 1 where studentid = ?";
        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, userId);
            int row = statement.executeUpdate();
            System.out.println("Student with Students id: " + userId + " Approved");
        }
        catch (SQLException se){
            System.out.println("Approve Student: Failed");
        }
    }
    public void viewPendingApprovals(){
        List<Student> pendingRequests = new ArrayList<>();
        try {
            statement = connection.prepareStatement("select student.studentId,user.name,student.branch from student join user on user.userId = student.studentid where student.isApproved = 0;");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
               System.out.println("Pending: StudentID: " + resultSet.getString(1) + "   Student Name: " + resultSet.getString(2)+" Student Branch: "+resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
