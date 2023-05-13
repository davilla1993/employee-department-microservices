package com.gbossoufolly.employeeservice.validators;

import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidator {

    public static List<String> validator(EmployeeDto employeeDto) {

        List<String> errors = new ArrayList<>();

        if(employeeDto == null) {
            errors.add("Employee ID is NULL");
            errors.add("Employee firstName is NULL");
            errors.add("Employee lastName is NULL");
            errors.add("Employee address is NULL");
            errors.add("Employee phone is NULL");

            return errors;
        }

        if(!StringUtils.hasLength(employeeDto.getFirstName())) {
            errors.add("Employee firstName field can't be empty ");
        }

        if(!StringUtils.hasLength((employeeDto.getLastName()))) {
            errors.add("Employee lastName field can't be empty");
        }

        if(!StringUtils.hasLength((employeeDto.getAddress()))) {
            errors.add("Employee address field can't be empty");
        }

        if(!StringUtils.hasLength((employeeDto.getPhone()))) {
            errors.add("Employee phone field can't be empty");
        }

        return errors;
    }
}
