package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class DummyDB {

    public static Map<Integer,Student> studentList;
    public static List<Course> courseList;
    public static Map<Integer,List<Integer>> registeredCourses;


    public static void init() {

        studentList = new HashMap<Integer,Student>();
        courseList = new ArrayList<Course>();
        registeredCourses = new HashMap<Integer, List<Integer>>();

        studentList.put(1,new Student(1,"Saransh","CS","101",5));
        studentList.put(2,new Student(2,"Stuti","CS",7));
        studentList.put(3,new Student(3,"Jachie","CS",3));
        studentList.put(4,new Student(4,"Vishal","EEE",5));
        studentList.put(5,new Student(5,"Komal","ENI",7));

        courseList.add(new Course(i+1,"DSA",2,3));
        courseList.add(new Course(i+1,"Database",3,4));
        courseList.add(new Course(i+1,"Physics",5,2));



    }

    public static void main(String[] args)
    {
        init();
    }

}