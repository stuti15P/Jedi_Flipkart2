package com.flipkart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import java.util.Date;

public class AdminDB {
	
	public static Map<Integer,Admin> adminList;
    public static List<Course> courseList;
    public static List<Student> studentList;
    public static List<Professor> profList;
    
    
    public static void init() {
    	adminList =new HashMap<Integer,Admin>();
    	Date date = new Date(2022-07-02);
    	
    	adminList.put(1 , new Admin("1","Amit","Admin","123",date));
    	adminList.put(2 , new Admin("2","Seema","Admin","123",date));
    	adminList.put(3 , new Admin("3","Zain","Admin","123",date));
    	
        courseList.add(new Course("CS101", "DSA", 2,3));
        courseList.add(new Course("CS110", "Database", 3,4));
        courseList.add(new Course("CS504","Physics",5,2));
        
        studentList.add(new Student("1","Saransh","CS",5));
        studentList.add(new Student("2","Stuti","CS",7));
        studentList.add(new Student("3","Jackie","CS",3));
        
        profList.add(new Professor(1,"CSE","Assistant Professor"));
        profList.add(new Professor(2,"CSE","Assistant Professor"));
        profList.add(new Professor(3,"EEE","Professor"));
    
    }
    
}
