package com.spring.JPAmapping.Springjpamapping.service;

import com.spring.JPAmapping.Springjpamapping.entity.Department;
import com.spring.JPAmapping.Springjpamapping.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
}
