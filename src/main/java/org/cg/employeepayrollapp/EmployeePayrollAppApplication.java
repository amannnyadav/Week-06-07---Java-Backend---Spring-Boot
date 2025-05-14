package org.cg.employeepayrollapp;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class EmployeePayrollAppApplication {
    private final EmployeeRepository employeeRepository;

    public EmployeePayrollAppApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping("/{employeeid}")
    public Employee updateEmployee(@PathVariable long employeeid,@Valid @RequestBody Employee employee) {
        return employeeRepository.findById(employeeid).map(Employee ->{
            Employee.setEmployeeName(employee.getEmployeeName());
            Employee.setEmployeeSalary(employee.getEmployeeSalary());
            employeeRepository.save(Employee);
            return ResponseEntity.ok(Employee);
        }).orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/{employeeid}")
    public String deleteEmployee(@PathVariable long employeeid) {
        if(employeeRepository.existsById(employeeid)) {
            employeeRepository.deleteById(employeeid);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "All employees deleted successfully";
    }

    @GetMapping("/count")
    public Long countEmployees() {
        return employeeRepository.count();
    }
    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppApplication.class, args);
    }

}
