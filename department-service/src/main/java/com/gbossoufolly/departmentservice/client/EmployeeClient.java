package com.gbossoufolly.departmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "EMPLOYEE-SERVICE", url = "${application.config.employees-url}")
public interface EmployeeClient {
}
