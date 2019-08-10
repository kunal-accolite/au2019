package com.example.employee.controller;

import com.example.employee.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository EmployeeRepository;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return EmployeeRepository.save(employee);
    }
}