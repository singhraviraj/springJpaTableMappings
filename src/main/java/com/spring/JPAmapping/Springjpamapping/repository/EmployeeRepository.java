package com.spring.JPAmapping.Springjpamapping.repository;

import com.spring.JPAmapping.Springjpamapping.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
