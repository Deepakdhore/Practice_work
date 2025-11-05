package com.mavenProejct.student.repository;

import com.mavenProejct.student.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class StudentRepo {
    ArrayList<Student> list=new ArrayList<>();

    //addStudent
    public String addStudent(Student student){
        list.add(student);
        return student.name+" added";
    }

    //getAllstudent
    public ArrayList<Student> getAllStudent(){
        System.out.println("-------retriving all student from repo------");
        return list;
    }


}
