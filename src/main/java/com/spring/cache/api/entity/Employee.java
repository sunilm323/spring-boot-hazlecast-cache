package com.spring.cache.api.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {


    @Id
    private int empId;

    private String empName;

    private String empSal;

    public Employee() {
    }

    public Employee(int empId, String empName, String empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSal() {
        return empSal;
    }

    public void setEmpSal(String empSal) {
        this.empSal = empSal;
    }
}
