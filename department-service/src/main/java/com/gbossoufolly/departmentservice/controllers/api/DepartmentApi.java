package com.gbossoufolly.departmentservice.controllers.api;

import com.gbossoufolly.departmentservice.dto.ApiResponse;
import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("/api/v1/department")
public interface DepartmentApi {

    @PostMapping("/save")
    ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto);

    @GetMapping("/all")
    ResponseEntity<List<DepartmentDto>> getAllDepartment();

    @PutMapping("/update/{departmentId}")
    ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto,
                                                    @PathVariable("departmentId") UUID departmentId);

    @GetMapping("departmentId/{departmentId}")
    ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("departmentId") UUID departmentId);

    @GetMapping("departmentCode/{departmentCode}")
    ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("departmentCode")
                                                                        String departmentCode);

    @DeleteMapping("delete/{departmentId}")
    ResponseEntity<ApiResponse> deleteDepartement(@PathVariable("departmentId") UUID departmentId);

    @GetMapping("one-department/{departmentId}")
    ResponseEntity<DepartmentDto> getOneDepartmentWithEmployees(@PathVariable("departmentId")
                                                                UUID departmentId);

    @GetMapping("/all-dept-empl")
    ResponseEntity<List<DepartmentDto>> getAllDepartmentWithEmployees();

}
