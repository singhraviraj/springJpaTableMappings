package com.spring.JPAmapping.Springjpamapping.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee manager;

    @OneToMany(mappedBy = "employee_departmentName")
    private Set<Employee> workers;

}
