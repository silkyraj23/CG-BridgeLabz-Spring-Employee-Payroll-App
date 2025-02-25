package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public String welcome(){
        return "Welcome to Employee Payroll App";
    }

}
