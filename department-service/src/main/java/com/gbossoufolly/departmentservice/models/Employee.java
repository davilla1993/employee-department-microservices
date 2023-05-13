package com.gbossoufolly.departmentservice.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private String address;

    private String phone;
}
