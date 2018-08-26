package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Student;
import com.springmvc.application.helpers.StudentNameParser;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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
}
