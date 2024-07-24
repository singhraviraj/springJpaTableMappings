package com.spring.JPAmapping.Springjpamapping.service;

import com.spring.JPAmapping.Springjpamapping.entity.Department;
import com.spring.JPAmapping.Springjpamapping.entity.Employee;
import com.spring.JPAmapping.Springjpamapping.repository.DepartmentRepository;
import com.spring.JPAmapping.Springjpamapping.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public Department assigningManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(departmentOptional.isPresent() && employeeOptional.isPresent()){
            Department department = departmentOptional.get();
            Employee employee = employeeOptional.get();
            department.setManager(employee);
            return departmentRepository.save(department);
        }else {
            throw new RuntimeException("Department or Employee not found");
        }
    }

    public Department assignedDepartmentOfEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        return employee.getManagedDepartment();
    }
}
