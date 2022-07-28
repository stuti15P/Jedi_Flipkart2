
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


    public  void init() {

        professorList = new HashMap<Integer,Professor>();
        

        
        professorList.put(1, new Professor("1","Dr. Amit Kumar", "Instructor", "passwordprof1", "CSE","Assistant Professor"));
        professorList.put(2, new Professor("2","Dr. Ashish Anand", "Instructor", "passwordpro2", "CSE","Assistant Professor"));
        professorList.put(3, new Professor("3","Dr. Himangi Sharma", "Instructor", "passwordprof3", "EEE","Professor"));


    }

   /* public static void main(String[] args)
    {
        init();
        for (Map.Entry<Integer, Professor> entry : professorList.entrySet())
        {
        	System.out.println("EntryNO: = " + entry.getKey() +  ", ProfessorId = " + entry.getValue().getUserID() +  ", ProfessorName = " + entry.getValue().getName()  +  ", Department = " + entry.getValue().getDepartment());
        }
        
    }  */

}