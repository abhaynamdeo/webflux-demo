package com.abhay.webfluxdemo.model;

import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Course.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "title", "title.empty");
        Course p = (Course) obj;
        if (p.getTitle() == "Error") {
            e.rejectValue("title", "InvalidTitle");
        }
    }
}
