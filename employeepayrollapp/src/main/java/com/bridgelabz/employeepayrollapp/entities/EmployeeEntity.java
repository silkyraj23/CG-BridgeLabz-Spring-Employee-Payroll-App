package com.bridgelabz.employeepayrollapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data

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



    // Parameterized constructor
    public EmployeeEntity(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

}
