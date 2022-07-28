package com.flipkart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.Date;

public class AdminDB {
	
	public static Map<Integer,Admin> adminList;
    public List<Course> courseList = new ArrayList<>();
    public static List<Student> studentList;
    public static List<Professor> profList;
    
    
    public  void init() {
    	adminList =new HashMap<Integer,Admin>();
    	Date date = new Date(2022-07-02);
    	
    	adminList.put(1 , new Admin("1","Amit","Admin","123",date));
    	adminList.put(2 , new Admin("2","Seema","Admin","123",date));
    	adminList.put(3 , new Admin("3","Zain","Admin","123",date));
    	
        courseList.add(new Course("CS101", "DSA", "2",3));
        courseList.add(new Course("CS110", "Database", "3",4));
        courseList.add(new Course("CS504","Physics","5",2));
        
         
        studentList.add(new Student("1","Saransh","Student", "password", "CS",5, true, true));
        studentList.add(new Student("2","Stuti", "Student", "password", "CS",7, true, true));
        studentList.add(new Student("3","Jackie", "Student", "password", "CS",3, true, true));
        
        
        
        profList.add(new Professor("1","Dr. Amit Kumar", "Instructor", "passwordprof1", "CSE","Assistant Professor"));
        profList.add(new Professor("2","Dr. Ashish Anand", "Instructor", "passwordpro2", "CSE","Assistant Professor"));
        profList.add(new Professor("3","Dr. Himangi Sharma", "Instructor", "passwordprof3", "EEE","Professor"));
    
    }
    
}
