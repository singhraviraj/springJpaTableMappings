package com.spring.JPAmapping.Springjpamapping.controller;

import com.spring.JPAmapping.Springjpamapping.entity.Employee;
import com.spring.JPAmapping.Springjpamapping.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

}
