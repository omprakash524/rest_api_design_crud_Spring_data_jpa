package com.rest_api_design.rest_api_design_crud.dao;

import com.rest_api_design.rest_api_design_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

