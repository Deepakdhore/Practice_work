package com.mavenProejct.student.model;

import org.springframework.stereotype.Component;

public class Doctors {
    long id;
    String name;
    String spl;

    public Doctors(long id, String name, String spl) {
        this.id = id;
        this.name = name;
        this.spl = spl;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spl='" + spl + '\'' +
                '}';
    }
}
