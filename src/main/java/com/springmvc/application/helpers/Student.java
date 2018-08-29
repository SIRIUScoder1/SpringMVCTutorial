package com.springmvc.application.helpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Date;

/**
 * Using JsonPropertyOrder returns properties in specific order.
 * Using JsonIgnoreProperties will not include that particular key in the Json response
 * Using JsonInclude actually remove all the values which are null, only value with parameters are sent
 * to the response. (TODO : Explore more functions of the JsonInclude)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills"})
@JsonPropertyOrder({"studentAddress", "student_name", "studentMobile","studentSkills"})
public class Student {

    /**
     * JsonProperty changes the json returned name to somethings else like studentName to student_name
     */
    @JsonProperty("student_name")
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
