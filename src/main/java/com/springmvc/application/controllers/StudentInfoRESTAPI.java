package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @RestController annotation actually avoids @ResponseBody annotation at each method.
 */
@RestController
public class StudentInfoRESTAPI {

    /**
     * REST API : Students added in the list and returning a JSON object
     * of the list.
     */
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ArrayList<Student> getStudentList() {
        Student student1 = new Student();
        student1.setStudentName("Karan");
        Student student2 = new Student();
        student2.setStudentName("Arab");
        Student student3 = new Student();
        student3.setStudentName("Sam");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        // this is java object Array list we need to convert this to json Object.
        // jackson converts into it json format.
        return studentArrayList;
    }

    /**
     * REST API : Retrieving a single student record
     *
     * @PathVariable extracts the variable under in the curly braces.
     */
    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("name") String studentName) {
        // Examplefetch the studentName details from the some place like DB using argument passed
        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentHobby("WWE");
        return student;
    }
}
