package com.springmvc.application.helpers;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

@Entity
@Table(name = "Student_Detail")
public class StudentDetailsTable {

    @Id @GeneratedValue(generator = "newGenerator")
    @GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = { @Parameter(value = "studentInfo" , name = "property")})
    @Column(name="Id")
    private int studentId;

    @Column(name="MobileNumber")
    private String mobileNumber;


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     *  Below code shows how one to one mapping can be done of StudentInfo and StudentDetailsTable
     *  @JoinColumn allows one to one relationship via Id column
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id")
    private StudentInfo studentInfo;

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }
}
