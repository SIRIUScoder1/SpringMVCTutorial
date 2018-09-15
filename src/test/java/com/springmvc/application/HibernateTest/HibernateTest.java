package com.springmvc.application.HibernateTest;

import com.springmvc.application.helpers.StudentDetailsTable;
import com.springmvc.application.helpers.StudentInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setName("Karan");

        StudentDetailsTable studentDetailsTable = new StudentDetailsTable();
        studentDetailsTable.setMobileNumber("9417373670");

        studentInfo1.setStudentDetailsTable(studentDetailsTable);
        // setting the studentInfo to student Detail object
        studentDetailsTable.setStudentInfo(studentInfo1);

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentInfo.class)
                    .addAnnotatedClass(StudentDetailsTable.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(studentInfo1);      // Insert the records in both tables.
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();     /** if sessionFactory is closed explicitly and the hbm2ddl.auto value is create-drop then it will drop
                                        all the tables after the closing of the sessionfactory.
                                    **/
    }
}
