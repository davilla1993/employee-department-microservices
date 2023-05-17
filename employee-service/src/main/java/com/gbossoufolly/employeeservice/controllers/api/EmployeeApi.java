package com.gbossoufolly.employeeservice.controllers.api;

import com.gbossoufolly.employeeservice.dto.ApiResponse;
import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/employee")
public interface EmployeeApi {

    @PostMapping("/save")
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto);

    @GetMapping("/all")
    ResponseEntity<List<EmployeeDto>> getAllEmployees();

    @GetMapping("/employeeId/{employeeId}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") UUID employeeId);

    @GetMapping("/employees/{departmentId}")
    ResponseEntity<List<EmployeeDto>> getEmployeeByDepartment(@PathVariable("departmentId") UUID departmentId);

    @PutMapping("update/{employeeId}")
    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                        @PathVariable("employeeId") UUID employeeId);

    @DeleteMapping("delete/{employeeId}")
    ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("employeeId") UUID employeeId);

}
