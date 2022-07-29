
package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class StudentDB {

    public static Map<Integer,Student> studentList;
    public static List<Course> courseList;
    public static Map<Integer,List<Integer>> registeredCourses;


    public  void init() {

        studentList = new HashMap<Integer,Student>();
        courseList = new ArrayList<Course>();
        registeredCourses = new HashMap<Integer, List<Integer>>();

        studentList.put(1, new Student("1","Saransh","Student", "password1", "CSE",5, true, true));
        studentList.put(2, new Student("2","Stuti", "Student", "password2", "CSE",5, true, true));
        studentList.put(3, new Student("3","Jackie", "Student", "password3", "CSE",3, true, true));
        studentList.put(4, new Student("4","Vishal", "Student", "password4", "EEE",7, true, true));
        studentList.put(5, new Student("5","Komal", "Student", "password5", "ENI",2, true, true));
        
        
        courseList.add(new Course("CS101", "DSA", "2",3));
        courseList.add(new Course("CS110", "Database", "3",4));
        courseList.add(new Course("CS504","Physics","5",2));



    }

  /*  public static void main(String[] args)
    {
        init();
        for (Map.Entry<Integer, Student> entry : studentList.entrySet()) 
        {
        	System.out.println("EntryNO: = " + entry.getKey() +  ", StudentId = " + entry.getValue().getUserID()  +  ", StudentName = " + entry.getValue().getName());
        }
        
    }  */

}