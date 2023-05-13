package com.gbossoufolly.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {

    private UUID id;

    private String name;

    private String surname;

    private String address;

    private String phone;
}
