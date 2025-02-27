package com.bridgelabz.employeepayrollapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name not valid")
    private String name;

    @NotNull(message = "This field can't be null")
    private String department;

    @DecimalMin(value = "200", message = "Salary can not be less than 200")
    @NotNull
    private Double salary;

    // Default constructor required by JPA
    public EmployeeEntity() {
    }

    // Parameterized constructor
    public EmployeeEntity(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public Double getSalary() {

        return salary;
    }

    public void setSalary(Double salary) {

        this.salary = salary;
    }
}
