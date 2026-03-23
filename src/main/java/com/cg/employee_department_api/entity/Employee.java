package com.cg.employee_department_api.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(1000)
    private double salary;

    @ElementCollection
    @CollectionTable(name = "employee_mobile", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "mobile_number")
    private Set<String> mobileNumbers;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee() {}
    // getters setters
}