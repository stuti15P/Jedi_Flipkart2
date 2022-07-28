
package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;

public class ProfessorDB {

    public static Map<Integer,Professor> professorList;
//    public static List<Course> courseList;
//    public static Map<Integer,List<Integer>> registeredCourses;


    public static void init() {

        professorList = new HashMap<Integer,Professor>();
        professorList.put(1,new Professor("1","Dr. Amit Kumar", "Mechanical","Assistant Professor"));
        professorList.put(2,new Professor("5","Dr. Ashish Anand", "Electrical","Junior Professor"));
        professorList.put(3,new Professor("4","Dr. Himangi Sharma", "Computer Science","Assistant Professor"));




    }

    public static void main(String[] args)
    {
        init();
        for (Map.Entry<Integer, Professor> entry : professorList.entrySet())
        {
        	System.out.println("EntryNO: = " + entry.getKey() +  ", ProfessorId = " + entry.getValue().getUserID() +  ", ProfessorName = " + entry.getValue().getName()  +  ", Department = " + entry.getValue().getDepartment());
        }
        
    }

}