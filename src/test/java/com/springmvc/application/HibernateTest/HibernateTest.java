package com.springmvc.application.HibernateTest;

import com.springmvc.application.helpers.StudentAddress;
import com.springmvc.application.helpers.StudentDetailsTable;
import com.springmvc.application.helpers.StudentInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setAddressDetail("Bangalore India");

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudent_name("Karan");
        studentInfo.setStudentAddress(studentAddress);

        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setStudent_name("Sam");
        studentInfo1.setStudentAddress(studentAddress);

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentInfo.class)
                                        .addAnnotatedClass(StudentAddress.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(studentInfo);
        session.save(studentInfo1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
