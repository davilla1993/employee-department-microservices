package com.gbossoufolly.departmentservice.validators;

import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartmentValidator {

    public static List<String> validate(DepartmentDto departmentDto) {

        List<String> errors = new ArrayList<>();

        if(departmentDto == null) {
            errors.add("Department code is NULL");
            errors.add("Department name is NULL");

            return errors;
        }

        if(!StringUtils.hasLength(departmentDto.getCode())) {
            errors.add("Department code field can't be empty");
        }

        if(!StringUtils.hasLength(departmentDto.getName())) {
            errors.add("Department name field can't be empty");
        }

        return errors;
    }
}
