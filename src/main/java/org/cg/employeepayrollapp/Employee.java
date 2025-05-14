package org.cg.employeepayrollapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeID;
    @NotEmpty(message = "EmployeeName must not be null")
    @Size(min = 2, max = 50, message = "EmployeeName must be between 2 and 50 characters")
    private String employeeName;
    @NotEmpty(message = "EmployeeSalary must not be null")

    private String employeeSalary;
    public Employee(){}
    public Employee(String employeeName, String employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }
    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
