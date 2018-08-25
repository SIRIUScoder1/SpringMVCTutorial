package com.springmvc.application.helpers;

import java.util.ArrayList;
import java.util.Date;

public class Student {

    private String studentName;
    private String studentHobby;

    private Long studentMobile;
    private Date studentDOB;
    private ArrayList<String> studentSkills;

    private Address studentAddress;

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentDOB(Date studentDOB) {
        this.studentDOB = studentDOB;
    }

    public void setStudentMobile(Long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public void setStudentSkills(ArrayList<String> studentSkills) {
        this.studentSkills = studentSkills;
    }

    public Long getStudentMobile() {
        return studentMobile;
    }

    public Date getStudentDOB() {
        return studentDOB;
    }

    public ArrayList<String> getStudentSkills() {
        return studentSkills;
    }
}
