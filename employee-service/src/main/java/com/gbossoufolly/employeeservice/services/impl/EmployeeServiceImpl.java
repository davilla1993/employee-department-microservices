package com.gbossoufolly.employeeservice.services.impl;

import com.gbossoufolly.employeeservice.dto.EmployeeDto;
import com.gbossoufolly.employeeservice.exceptions.EntityAlreadyExistException;
import com.gbossoufolly.employeeservice.exceptions.EntityNotFoundException;
import com.gbossoufolly.employeeservice.exceptions.ErrorCode;
import com.gbossoufolly.employeeservice.exceptions.InvalidEntityException;
import com.gbossoufolly.employeeservice.mappers.EmployeeMapper;
import com.gbossoufolly.employeeservice.models.Employee;
import com.gbossoufolly.employeeservice.repository.EmployeeRepository;
import com.gbossoufolly.employeeservice.services.EmployeeServices;
import com.gbossoufolly.employeeservice.validators.EmployeeValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeServices {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        List<String> errors = EmployeeValidator.validator(employeeDto);

        if(!errors.isEmpty()) {
            log.error("Employee is not valid {}", employeeDto);
            throw new InvalidEntityException("Employee is not valid",
                    ErrorCode.EMPLOYEE_NOT_VALID, errors);
        }

        String email = employeeDto.getEmail();
        Employee existEmployee = employeeRepository.findByEmail(email);

        if(existEmployee != null) {
            log.error("Employee with email " + email + "already exists.");
            throw new EntityAlreadyExistException("Employee with email " + email + " already exists",
                    ErrorCode.EMPLOYEE_ALREADY_EXISTS);
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee newEmployee = employeeRepository.save(employee);
        EmployeeDto newEmployeeDto = EmployeeMapper.mapToEmployeeDto(newEmployee);

        return newEmployeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> listEmployee = employeeRepository.findAll();

        if(listEmployee.isEmpty()) {
            log.warn("List of employee is empty");
        }

        List<EmployeeDto> listEmployeeDto = listEmployee.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

        return listEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(UUID id) {

        if(id == null) {
            log.error("Employee ID is NULL");
        }

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID " + id,
                        ErrorCode.EMPLOYEE_NOT_FOUND));

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getEmployeeByDepartment(UUID departmentId) {

        if(departmentId == null) {
            log.error("Department ID is NULL");
        }

        List<Employee> employee = employeeRepository.findByDepartmentId(departmentId);

        if(employee.isEmpty()) {
            log.error("Any Employee is found with the department ID : " + departmentId);
        }

        List<EmployeeDto> employeeDtos = employee.stream()
                .map(empl -> EmployeeMapper.mapToEmployeeDto(empl))
                .collect(Collectors.toList());

        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, UUID employeeId) {

        List<String> errors = EmployeeValidator.validator(employeeDto);

        if(!errors.isEmpty()) {
            log.error("Employee is not VALID");
            throw new InvalidEntityException("Employee is NOT VALID",
                    ErrorCode.EMPLOYEE_NOT_VALID);
        }

        if(employeeId == null){
            log.error("Employee ID is NULL");
        }

        Employee existEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID " + employeeId,
                ErrorCode.EMPLOYEE_NOT_FOUND));

        existEmployee.setFirstName(employeeDto.getFirstName());
        existEmployee.setLastName(employeeDto.getLastName());
        existEmployee.setEmail(employeeDto.getEmail());
        existEmployee.setPhone(employeeDto.getPhone());
        existEmployee.setDepartmentId(employeeDto.getDepartmentId());

        Employee updateEmployee = employeeRepository.save(existEmployee);
        EmployeeDto updateEmployeeDto = EmployeeMapper.mapToEmployeeDto(updateEmployee);

        return updateEmployeeDto;
    }

    @Override
    public void deleteEmployee(UUID employeeId) {

        if(employeeId == null) {
            log.error("Employee ID is NULL");
        }

        Employee employee = employeeRepository.findById(employeeId)
                        .orElseThrow(() -> new EntityNotFoundException("Employee is not found with ID " + employeeId,
                                ErrorCode.EMPLOYEE_NOT_FOUND));

        employeeRepository.deleteById(employeeId);
    }
}
