package com.gbossoufolly.employeeservice.validators;

import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static List<String> validator(EmployeeDto employeeDto) {

        List<String> errors = new ArrayList<>();

        if(employeeDto == null) {
            errors.add("Employee firstName is NULL");
            errors.add("Employee lastName is NULL");
            errors.add("Employee email is NULL");
            errors.add("Employee phone is NULL");

            return errors;
        }

        if(!StringUtils.hasLength(employeeDto.getFirstName())) {
            errors.add("Employee firstName field can't be empty ");
        }

        if(!StringUtils.hasLength((employeeDto.getLastName()))) {
            errors.add("Employee lastName field can't be empty");
        }

        if(!StringUtils.hasLength((employeeDto.getEmail()))) {
            errors.add("Employee email field can't be empty");

        } else if (!validateEmail(employeeDto.getEmail())) {
            errors.add("Employee email is not VALID");
        }

        if(!StringUtils.hasLength((employeeDto.getPhone()))) {
            errors.add("Employee phone field can't be empty");
        }

        return errors;
    }
}
