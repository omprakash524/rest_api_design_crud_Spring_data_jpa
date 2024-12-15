package com.rest_api_design.rest_api_design_crud.service;

import com.rest_api_design.rest_api_design_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
