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

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int studentId;

    // @Transient can help in not considering a particular column for database only
    @Column(name="Name", nullable = false)      // the column cannot be null.
    private String name;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
