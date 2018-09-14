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
@Table(name = "STUDENT_INFORMATION")
public class StudentInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RollNo")
    private int rollNo;

    // @Transient can help in not considering a particular column for database only
    @Column(name="Name", nullable = false)      // the column cannot be null.
    private String name;

    @Column(name="Birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthddate;

    public Date getBirthddate() {
        return birthddate;
    }

    public void setBirthddate(Date birthddate) {
        this.birthddate = birthddate;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
