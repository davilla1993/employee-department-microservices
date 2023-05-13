package com.gbossoufolly.employeeservice.services;

import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import java.util.List;
import java.util.UUID;

public interface EmployeeServices {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(UUID id);

    List<EmployeeDto> getEmployeeByDepartment(UUID departmentId);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, UUID employeeId);

    void deleteEmployee(UUID employeeId);
}
