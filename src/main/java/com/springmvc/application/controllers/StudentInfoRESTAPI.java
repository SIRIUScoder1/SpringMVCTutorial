package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;

/**
 * @RestController annotation actually avoids @ResponseBody annotation at each method.
 */
@RestController
public class StudentInfoRESTAPI {

    /**
     * REST API : Students added in the list and returning a JSON object
     * of the list.
     *
     * produces in @RequestMapping allows the sender to send data in a specific format
     * xml or json
     */
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
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

    /**
     * @RequestBody allows conversion of json/xml into java based object
     * consumes allows to consume only a specific json/xml format (depends on what you specified.)
     * @param studentName
     * @param student
     * @return
     */
    @RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {

        // matching the studentName with database
        //update the matching the student information also
        System.out.println(studentName);
        System.out.println(student.getStudentName() + " " + student.getStudentHobby());

        //return new ResponseEntity<Void>(HttpStatus.OK); // making status code according to your usecase
        /**
         *  If ResponseEntity<Boolean>(true,HttpStatus.OK) ---> sends a response body as well as status through rest api
         *
         *  Sending customized response headers.
         */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key1","value1");
        httpHeaders.add("key2","value2");
        return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);
    }

    /**
     * POST REST API --> neads to insert some new information to server and then for reading we can use a
     * GET type of REST API.
     */
    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> postStudent(@RequestBody Student student) {
        System.out.println(student.getStudentName() + " " + student.getStudentHobby());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", ServletUriComponentsBuilder.fromCurrentRequest()
                                                            .path("/{name}")
                                                            .buildAndExpand(student.getStudentName()).toUri().toString());
        return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {
        System.out.println(studentName);
        // delete this record with studentName
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
