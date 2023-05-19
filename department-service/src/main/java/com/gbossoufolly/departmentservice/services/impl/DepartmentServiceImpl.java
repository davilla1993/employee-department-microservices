package com.gbossoufolly.departmentservice.services.impl;

import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import com.gbossoufolly.departmentservice.dto.FullDepartmentDto;
import com.gbossoufolly.departmentservice.exceptions.EntityAlreadyExistException;
import com.gbossoufolly.departmentservice.exceptions.EntityNotFoundException;
import com.gbossoufolly.departmentservice.exceptions.ErrorCode;
import com.gbossoufolly.departmentservice.exceptions.InvalidEntityException;
import com.gbossoufolly.departmentservice.mappers.DepartmentMapper;
import com.gbossoufolly.departmentservice.models.Department;
import com.gbossoufolly.departmentservice.repository.DepartmentRepository;
import com.gbossoufolly.departmentservice.services.DepartmentService;
import com.gbossoufolly.departmentservice.validators.DepartmentValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        List<String> errors = DepartmentValidator.validate(departmentDto);

        if(!errors.isEmpty()){
            log.error("DepartmentDto is not valid {}", departmentDto);
            throw new InvalidEntityException("Department is not valid",
                    ErrorCode.DEPARTMENT_NOT_VALID, errors);
        }

        String departmentCode = departmentDto.getCode();
        Department existDepartment = departmentRepository.findByCode(departmentCode);
        if(existDepartment != null){
            log.error("A department with code : " +  departmentCode + " already exists");
            throw new EntityAlreadyExistException("Department already exixts",
                    ErrorCode.DEPARTMENT_ALREADY_USE);
        }

        Department department = DepartmentMapper.mapToDepartement(departmentDto);
        Department newDepartment = departmentRepository.save(department);
        DepartmentDto newDepartmentDto = DepartmentMapper.mapToDepartmentDto(newDepartment);

        return newDepartmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {

        List<Department> departements = departmentRepository.findAll();

        List<DepartmentDto> departmentDtos = departements.stream()
                .map(dept -> DepartmentMapper.mapToDepartmentDto(dept))
                .collect(Collectors.toList());

        return departmentDtos;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, UUID departmentId) {

        List<String> errors = DepartmentValidator.validate(departmentDto);

        if(!errors.isEmpty()) {
            log.error("Department is not valid {}", departmentDto);
            throw new InvalidEntityException("Department is not valid",
                    ErrorCode.DEPARTMENT_NOT_VALID, errors);
        }

        if(departmentId == null) {
            log.error("Department ID is null");
        }

        Department existDepartment = departmentRepository.findById(departmentId)
                        .orElseThrow(() ->
                                 new EntityNotFoundException("Department not found with ID: " +
                departmentId, ErrorCode.DEPARTMENT_NOT_FOUND));


        existDepartment.setCode(departmentDto.getCode());
        existDepartment.setName(departmentDto.getName());

        Department updateDepartment = departmentRepository.save(existDepartment);
        DepartmentDto updateDepartmentDto = DepartmentMapper.mapToDepartmentDto(updateDepartment);

        return updateDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentById(UUID departmentId) {

        if(departmentId == null) {
            log.error("Department ID is NULL");
        }

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Department not found with ID: " + departmentId,
                        ErrorCode.DEPARTMENT_NOT_FOUND
                ));

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        if(!StringUtils.hasLength(departmentCode)) {
            log.error("Departemnt Code is NULL");
        }

        Department department = departmentRepository.findByCode(departmentCode);
        if(department == null) {
            log.error("Department not found with code: " + departmentCode);
            throw new EntityNotFoundException("Department not found",
                    ErrorCode.DEPARTMENT_NOT_FOUND);
        }

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

    @Override
    public void deleteDepartement(UUID departmentId) {

        if(departmentId == null) {
            log.error("Department ID is NULL");
        }

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: "
                + departmentId, ErrorCode.DEPARTMENT_NOT_FOUND));

        departmentRepository.delete(department);
    }

    @Override
    public List<FullDepartmentDto> getAllDepartmentWithEmployees(UUID departmentId) {

        if(departmentId == null) {
            log.error("Department ID is NULL");
        }

        Department existDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID " + departmentId,
                        ErrorCode.DEPARTMENT_NOT_FOUND));


        return null;
    }
}
