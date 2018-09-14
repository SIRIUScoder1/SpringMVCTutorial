package com.springmvc.application.HibernateTest;

import com.springmvc.application.helpers.StudentInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        StudentInfo studentInfo1 = new StudentInfo();
        studentInfo1.setName("temp");
        studentInfo1.setRollNo(2);
        studentInfo1.setBirthddate(new Date());
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentInfo.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(studentInfo1);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();     /** if sessionFactory is closed explicitly and the hbm2ddl.auto value is create-drop then it will drop
                                        all the tables after the closing of the sessionfactory.
                                    **/
    }
}
