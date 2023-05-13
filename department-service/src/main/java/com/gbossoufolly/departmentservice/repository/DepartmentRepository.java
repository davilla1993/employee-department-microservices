package com.gbossoufolly.departmentservice.repository;

import com.gbossoufolly.departmentservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    Department findByCode(String departmentCode);
}
