package com.sado4eg.userinfo.web;

import com.sado4eg.userinfo.beans.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "first.name.is.empty","First Name is required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "last.name.is.empty", "Last Name is required");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.is.empty", "email is required");

    }
}
