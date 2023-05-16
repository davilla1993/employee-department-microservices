package com.gbossoufolly.employeeservice.controllers;

import com.gbossoufolly.employeeservice.controllers.api.EmployeeApi;
import com.gbossoufolly.employeeservice.dto.ApiResponse;
import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import com.gbossoufolly.employeeservice.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController implements EmployeeApi{

    private EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @Override
    public ResponseEntity<EmployeeDto> createEmployee(EmployeeDto employeeDto) {

        EmployeeDto newEmployee = employeeServices.createEmployee(employeeDto);

        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<EmployeeDto> listOfEmployees = employeeServices.getAllEmployees();

        return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(UUID employeeId) {

        EmployeeDto employee = employeeServices.getEmployeeById(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getEmployeeByDepartment(UUID departmentId) {

        List<EmployeeDto> employees = employeeServices.getEmployeeByDepartment(departmentId);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(EmployeeDto employeeDto, UUID employeeId) {

        EmployeeDto updatedEmployee = employeeServices.updateEmployee(employeeDto, employeeId);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteEmployee(UUID employeeId) {

        employeeServices.deleteEmployee(employeeId);

        return new ResponseEntity<>(new ApiResponse(
                "Employee is deleted sucessfully", true), HttpStatus.OK);
    }
}
