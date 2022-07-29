/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Grade;



/**
 * @author stuti.priyambda
 *
 */
public class ProfessorServiceImpl implements ProfessorService{

	List<Grade> gradeStudent= new ArrayList<>();
	
	
	public boolean addGrade(String studentId, String courseId, int grade) {
		// TODO Auto-generated method stub
		
		//Grade g = new Grade();
		Grade g = new Grade(studentId, courseId, grade);
//		g.setStudentId(studentId);
//		g.setCourseId(courseId);
//		g.setGrade(grade);
		
		System.out.println("The student with Id " + g.getStudentId() + " is graded "+ g.getGrade());
		
		gradeStudent.add(g);
		
		return true;
	}

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(String profId) {
		// TODO Auto-generated method stub	
		List<EnrolledStudent> enrolledStudent= new ArrayList<>();
		EnrolledStudent s1 = new EnrolledStudent();
		EnrolledStudent s2 = new EnrolledStudent();
		EnrolledStudent s3 = new EnrolledStudent();
		s1.setStudentId("181CS111");
		s1.setCourseId("CS19");
		s1.setCourseName("OS");
		
		s2.setStudentId("181IT211");
		s2.setCourseId("IT114");
		s2.setCourseName("DBMS");
		
		s3.setStudentId("181CS213");
		s3.setCourseId("CS134");
		s3.setCourseName("ACD");
		
		enrolledStudent.add(s1);
		enrolledStudent.add(s2);
		enrolledStudent.add(s3);
		
		return enrolledStudent;
	
		
	}

	@Override
	public List<Course> viewOwnCourse(String profId) {
		
		// fetch course details under this prof and show
		
				List<Course> course= new ArrayList<>();
				Course c1= new Course("IT211","DBMS","Jk19",4);
				Course c2=new Course("Cs211","OS","JK19",3);
				Course c3=new Course("ME211","ACD","Jk19",4);
				
				course.add(c1);
				course.add(c2);
				course.add(c3);
				
				return course;
		
	}

}







