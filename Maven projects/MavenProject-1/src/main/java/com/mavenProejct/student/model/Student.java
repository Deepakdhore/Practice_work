package com.mavenProejct.student.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    public String name;
    public int rollnumber;

    public Student(String name,int rollnumber){
        this.name=name;
        this.rollnumber=rollnumber;
    }

}
