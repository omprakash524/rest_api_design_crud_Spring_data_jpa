package com.rest_api_design.rest_api_design_crud.service;

import com.rest_api_design.rest_api_design_crud.dao.EmployeeRepository;
import com.rest_api_design.rest_api_design_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("did not find emp id: "+theId);
        }
        return employee;
//        or
//        return employeeRepository.findById(theId).orElseThrow(()-> new RuntimeException("error: "+theId));
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
