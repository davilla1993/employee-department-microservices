package com.gbossoufolly.departmentservice.controllers;

import com.gbossoufolly.departmentservice.controllers.api.DepartmentApi;
import com.gbossoufolly.departmentservice.dto.ApiResponse;
import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import com.gbossoufolly.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DepartmentController implements DepartmentApi{


    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public ResponseEntity<DepartmentDto> createDepartment(DepartmentDto departmentDto) {

        DepartmentDto newDepartment = departmentService.createDepartment(departmentDto);

        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {

        List<DepartmentDto> listDepartment = departmentService.getAllDepartment();

        return new ResponseEntity<>(listDepartment, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DepartmentDto> updateDepartment(DepartmentDto departmentDto, UUID departmentId) {

        DepartmentDto updateDepartment = departmentService.updateDepartment(departmentDto, departmentId);

        return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartmentById(UUID departmentId) {

        DepartmentDto department = departmentService.getDepartmentById(departmentId);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<DepartmentDto> getDepartmentByCode(String departmentCode) {

        DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ApiResponse> deleteDepartement(UUID departmentId) {

        departmentService.deleteDepartement(departmentId);

        return new ResponseEntity<>(new ApiResponse(
                "Department is deleted successfully", true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DepartmentDto>> getAllDepartmentWithEmployees() {
        return null;
    }

    @Override
    public ResponseEntity<DepartmentDto> getOneDepartmentWithEmployees(UUID departmentId) {
        return null;
    }


}
