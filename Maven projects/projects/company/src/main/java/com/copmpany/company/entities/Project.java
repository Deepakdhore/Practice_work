package com.copmpany.company.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Project {
    @Id
    private int pid;
    @Column
    private String projectName;

    @ManyToMany
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", projectName='" + projectName + '\'' +
                ", Employee=" + employees +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {return employees;}

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
