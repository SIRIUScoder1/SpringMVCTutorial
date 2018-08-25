package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomePage {

    @RequestMapping(value = "/addmissionForm", method = RequestMethod.GET)
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
            // execute something.
        }

        ModelAndView submitAdmissionForm = new ModelAndView("admissionSuccess");
        return submitAdmissionForm;
    }
}
