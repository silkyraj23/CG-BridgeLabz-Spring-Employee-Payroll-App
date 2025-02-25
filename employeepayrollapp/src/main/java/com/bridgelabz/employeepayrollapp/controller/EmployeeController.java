package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.entities.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String welcome(){
        return "Welcome to Employee Payroll App";
    }

    @GetMapping("/all")    //get list of all employees
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")    //get employees by id
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")    //add new employee to the application
    public EmployeeEntity addNewEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/update/details/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployeeDetails(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeEntity updatedEmployee) {
        EmployeeEntity employee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Employee deleted successfully";
        }
        return "Employee Not Found";
    }
}