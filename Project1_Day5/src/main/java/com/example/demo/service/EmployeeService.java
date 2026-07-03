package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public Employee createEmployee(Employee employee) {

        String designation = employee.getDesignation();

        if (designation.equalsIgnoreCase("Programmer")) {
            employee.setSalary(25000.00);
        } else if (designation.equalsIgnoreCase("Manager")) {
            employee.setSalary(30000.00);
        } else if (designation.equalsIgnoreCase("Tester")) {
            employee.setSalary(20000.00);
        } else {
            return null; // No Access
        }

        return employeeRepository.save(employee);
    }

    // Display All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Raise Salary
    public String raiseSalary(int id, double amount) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            return "Employee Not Found";
        }

        employee.setSalary(employee.getSalary() + amount);
        employeeRepository.save(employee);

        return "Salary Updated Successfully";
    }
}