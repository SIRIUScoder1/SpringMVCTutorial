package com.springmvc.application.helpers;

import java.beans.PropertyEditorSupport;

public class StudentNameParser extends PropertyEditorSupport {

    @Override
    public void setAsText(String studentName) throws IllegalArgumentException {
        if(studentName.contains("Mr.") || studentName.contains("Ms.")) {
            setValue(studentName);
        } else {
            studentName = "Ms." + studentName;
            setValue(studentName);      // What ever value we provide to setValue ---- spring MVC will use the same value to perform the data binding for the studentName property.
        }
    }
}
