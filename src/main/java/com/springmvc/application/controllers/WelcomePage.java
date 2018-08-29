package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Student;
import com.springmvc.application.helpers.StudentNameParser;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class WelcomePage {

    /**
     * How the binding can be customised using initBinder annotation and also using WebDataBinder
     */
    @InitBinder
    public void intBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");     // allows customization of the dates format  <---- This is custom property editor classes
        binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "studentName", new StudentNameParser());
    }


    @RequestMapping(value = "/admissionForm", method = RequestMethod.GET)
    public ModelAndView admissionFormPage(final HttpServletRequest request, final HttpServletResponse response) {
        ModelAndView admissionFormModel = new ModelAndView("admissionForm");
        return admissionFormModel;
    }

    @RequestMapping(value = "/submitAdmissionForm", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student, BindingResult result) {

        /**
         *  If any data binding errors comes then is can be catched using BindingResult class
         *  and including small snippet below
         */
        if(result.hasErrors()) {
            System.out.println("Has Errors");
            ModelAndView errorsView = new ModelAndView("admissionForm");
            return errorsView;
        }

        ModelAndView submitAdmissionForm = new ModelAndView("admissionSuccess");
        return submitAdmissionForm;
    }

    /**
     * REST API : Students added in the list and returning a JSON object
     * of the list.
     */
    @ResponseBody
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
    @ResponseBody
    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("name") String studentName) {
        // Examplefetch the studentName details from the some place like DB using argument passed
        Student student = new Student();
        student.setStudentName(studentName);
        student.setStudentHobby("WWE");
        return student;
    }
}
