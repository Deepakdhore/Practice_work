package com.mavenProejct.student.service;

import com.mavenProejct.student.model.Student;
import com.mavenProejct.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class StudentService {

    private StudentRepo repo;
    @Autowired
    public StudentService(StudentRepo repo)
    {
        this.repo=repo;
    }



    //AddnewStudent
    public String addStudent(String[] str){
        Student newStudent =new Student(str[0],Integer.parseInt(str[1]));
        repo.addStudent(newStudent);
        return str[0]+" Added";
    }

    //getallstudent
    public ArrayList<Student> getAllStudnet(){
        return repo.getAllStudent();
    }

}
