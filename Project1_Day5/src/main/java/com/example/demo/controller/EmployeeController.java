package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Press 1 - Create Employee
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.createEmployee(employee);

        if (savedEmployee == null) {
            return "No Access! Only Programmer, Manager, Tester are allowed.";
        }

        return "Employee Created Successfully";
    }

    // Press 2 - Display All Employees
    @GetMapping("/display")
    public List<Employee> displayEmployees() {
        return employeeService.getAllEmployees();
    }

    // Press 3 - Raise Salary
    @PutMapping("/raiseSalary/{id}/{amount}")
    public String raiseSalary(@PathVariable int id,
                              @PathVariable double amount) {

        return employeeService.raiseSalary(id, amount);
    }
}