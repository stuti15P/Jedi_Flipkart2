
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


    public static void init() {

        studentList = new HashMap<Integer,Student>();
        courseList = new ArrayList<Course>();
        registeredCourses = new HashMap<Integer, List<Integer>>();

        studentList.put(1,new Student("s1","Saransh","student","a00","CS",1,true,true));
        studentList.put(1,new Student("s2","Stuti","student","a11","EE",1,false,true));
        studentList.put(1,new Student("s3","Komal","student","a22","CS",1,true,true));
        studentList.put(1,new Student("s4","Vishal","student","a33","CS",1,false,true));
        studentList.put(1,new Student("s5","Bhajan","student","a44","CS",1,true,false));
        studentList.put(1,new Student("s6","Nova","student","a55","CS",1,true,true));

        courseList.add(new Course("CS101", "DSA", "2",3));
        courseList.add(new Course("CS110", "Database", "3",4));
        courseList.add(new Course("CS504","Physics","5",2));



    }

    public static void main(String[] args)
    {
        init();
        for (Map.Entry<Integer, Student> entry : studentList.entrySet()) 
        {
        	System.out.println("EntryNO: = " + entry.getKey() +  ", StudentId = " + entry.getValue().getUserID()  +  ", StudentName = " + entry.getValue().getName());
        }
        
    }

}