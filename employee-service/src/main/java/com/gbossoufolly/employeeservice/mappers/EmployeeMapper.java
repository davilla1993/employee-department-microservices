package com.gbossoufolly.employeeservice.mappers;

import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import com.gbossoufolly.employeeservice.models.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .departmentId(employeeDto.getDepartmentId())
                .build();

        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .departmentId(employee.getDepartmentId())
                .build();
    }
}
