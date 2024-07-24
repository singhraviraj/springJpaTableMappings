package com.spring.JPAmapping.Springjpamapping.controller;

import com.spring.JPAmapping.Springjpamapping.entity.Department;
import com.spring.JPAmapping.Springjpamapping.entity.Employee;
import com.spring.JPAmapping.Springjpamapping.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping(path = "/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public Department assigningManagerToDepartment(@PathVariable Long departmentId,
                                                   @PathVariable Long employeeId){
        return departmentService.assigningManagerToDepartment(departmentId,employeeId);
    }

    @GetMapping(path = "/assignedDepartmentOfEmployee/{employeeId}")
    public Department assignedDepartmentOfEmployee(@PathVariable Long employeeId){
        return departmentService.assignedDepartmentOfEmployee(employeeId);
    }
}
