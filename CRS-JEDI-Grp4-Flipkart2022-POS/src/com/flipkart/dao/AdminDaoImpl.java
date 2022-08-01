package com.flipkart.dao;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDaoInterface;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.app.CRSApplication.connection;

//import static com.flipkart.constants.SQLQueriesConstants.*;
public class AdminDaoImpl extends AdminDaoInterface {
    Connection connection = DBUtils.getConnection();

    private PreparedStatement statement = null;
    public void addUser(User user){
        statement = connection.preparedStatement
    }

}
