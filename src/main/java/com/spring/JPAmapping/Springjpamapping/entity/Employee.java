package com.spring.JPAmapping.Springjpamapping.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private Department managedDepartment;

    @ManyToOne
    @JoinColumn(name = "worker_department_Id")
    private Department employee_departmentName;
}
