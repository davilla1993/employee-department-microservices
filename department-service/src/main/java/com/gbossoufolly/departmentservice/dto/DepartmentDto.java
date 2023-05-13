package com.gbossoufolly.departmentservice.dto;

import com.gbossoufolly.departmentservice.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDto {


    private UUID id;

    private String code;

    private String name;

}
