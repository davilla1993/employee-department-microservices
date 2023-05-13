package com.gbossoufolly.departmentservice.mappers;

import com.gbossoufolly.departmentservice.dto.DepartmentDto;
import com.gbossoufolly.departmentservice.models.Department;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .code(department.getCode())
                .name(department.getName())
                .build();
    }


    public static Department mapToDepartement(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.getId())
                .code(departmentDto.getCode())
                .name(departmentDto.getName())
                .build();
    }


}
