package com.springmvc.application.handlers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class DaysOfWeekBasedAccess extends HandlerInterceptorAdapter {

    /**
     * if this method returns true then application will handle the request
     * if this method returns false then application will not handle the request
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

//        Calendar calendar = Calendar.getInstance();
//        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
//        if(dayOfWeek == 1) {
//            response.getWriter().write("The website is closed cause it's sunday... Yayy");
//            return false;
//        }
        return true;
    }

    /**
     * The method gets invoked after Spring MVC executes the request handler method for the request.
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptorAdaptor : postHandle called " + request.getRequestURI().toString());
    }

    /**
     * The method gets invoked after the response object is produced by the view for the request.
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("HandlerInterceptorAdaptor : afterCompletion called " + request.getRequestURI().toString());
    }
}
