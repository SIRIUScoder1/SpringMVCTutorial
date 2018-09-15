package com.springmvc.application.helpers;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * Below is the model class for student Information table.
 * @Entity -> tells class is an entity, that is class written to hold and
 * upload to or get data from database.
 *
 * @Id It is use to specify the primary key.
 *
 * @Table allows the table name which is needed to be accessed.
 *
 * GenerationType.AUTO, GenerationType.IDENTITY, GenerationType.SEQUENCE
 */
@Entity
@Table(name = "STUDENT")
public class StudentInfo {
    @Id
    @GeneratedValue
    private int student_id;

    private String student_name;

    @ManyToOne(cascade = CascadeType.ALL)
    private StudentAddress studentAddress;

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_name() {
        return student_name;
    }
}
