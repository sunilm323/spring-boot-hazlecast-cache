package com.spring.cache.api.controller;

import com.spring.cache.api.entity.Employee;
import com.spring.cache.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache-api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/allEmployees")
    public List<Employee>  getEmployees(){
        return service.getAllEmployee();
    }

    @GetMapping("/getEmp/{empId}")
    public Employee getEmployee(@PathVariable int empId){
        return service.getEmployeeById(empId);
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        return service.deleteEmployee(empId);
    }

}
