package com.copmpany.company.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Employee {
    @Id
    private int eid;
    @Column
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }

    @ManyToMany
    private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
