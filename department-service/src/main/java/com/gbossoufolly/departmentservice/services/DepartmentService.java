package com.gbossoufolly.departmentservice.services;

import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import com.gbossoufolly.departmentservice.dto.FullDepartmentDto;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(DepartmentDto departmentDto, UUID departmentId);

    DepartmentDto getDepartmentById(UUID departmentId);

    DepartmentDto getDepartmentByCode(String departmentCode);

    void deleteDepartement(UUID departmentId);

    List<FullDepartmentDto> getAllDepartmentWithEmployees(UUID departmentId);




}
