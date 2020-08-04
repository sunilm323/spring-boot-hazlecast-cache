package com.spring.cache.api.service;

import com.spring.cache.api.entity.Employee;
import com.spring.cache.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Cacheable(cacheNames = {"employeeCache"})
    public List<Employee> getAllEmployee(){
        System.out.println("First Time hit in DATABASE..getAllEmployee()");
        return repository.findAll();
    }

    @Cacheable(value = "employeeCache" , key = "#empId",
              condition = "#employee.empName.length() > 10", unless="#result.name should be less than 10 char")
    public Employee getEmployeeById(int empId){
        System.out.println("First Time hit in DATABASE..getEmployeeById()");
        return repository.findById(empId);
    }

    @CachePut( cacheNames = "employeeCache" , key = "#employee.empId",
               condition = "#employee.empName.length() > 10", unless="#result.name nameShouldBeMoreThan10")
    public String updateEmployee(Employee employee){
        Employee emp = repository.findById(employee.getEmpId());
        emp.setEmpId(employee.getEmpId());
        emp.setEmpName(employee.getEmpName());
        emp.setEmpSal(employee.getEmpSal());
        repository.save(emp);
        System.out.println("First Time hit in DATABASE..updateEmployee()");
        return "Updated was successfully";
    }

    @CacheEvict(value = "employeeCache", key = "#empId")
    public String deleteEmployee(int empId){
        repository.deleteById(empId);
        return " Record deleted was successfully with "+empId+" id";
    }

}
