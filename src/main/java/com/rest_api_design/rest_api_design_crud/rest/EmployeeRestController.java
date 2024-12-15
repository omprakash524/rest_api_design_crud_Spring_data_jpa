package com.rest_api_design.rest_api_design_crud.rest;

import com.rest_api_design.rest_api_design_crud.entity.Employee;
import com.rest_api_design.rest_api_design_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("EmployeeId not found: "+employeeId);
        }
        return theEmployee;
    }

    // add mapping to post/employee - add new employee
    @PostMapping("/employees/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        // also just incase they pass id in json  - set id to 0
        // this is a force to save the item - instead of update
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // add mapping to PUT/employee - to update
    @PutMapping("/employees/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // add mapping for delete/ employees/{employeesId} - to delete
    @DeleteMapping("/employees/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempdb = employeeService.findById(employeeId);
        if(tempdb==null){
            throw new RuntimeException("Employee Id not found: "+employeeId);
}
        employeeService.deleteById(employeeId);
        return "Deleted employee Id: "+employeeId;
    }

}
