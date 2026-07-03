package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("Press 1. Create Employee");
            System.out.println("Press 2. Display Employees");
            System.out.println("Press 3. Raise Salary");
            System.out.println("Press 4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                while (true) {

                	System.out.println("Enter Name:");
                	String name = sc.nextLine();

                	System.out.println("Enter Age:");
                	int age = Integer.parseInt(sc.nextLine());

                	System.out.println("Enter Designation:");
                	String designation = sc.nextLine();

                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setAge(age);
                    employee.setDesignation(designation);

                    Employee savedEmployee = employeeService.createEmployee(employee);

                    if (savedEmployee == null) {
                        System.out.println("No Access! Invalid Designation");
                    } else {
                        System.out.println("Employee Created Successfully");
                    }

                    System.out.println("Do you want to continue? (yes/no)");
                    String ans = sc.next();

                    if (!ans.equalsIgnoreCase("yes")) {
                        break;
                    }
                }

                break;

            case 2:

                List<Employee> employees = employeeService.getAllEmployees();

                if (employees.isEmpty()) {
                    System.out.println("No Employees Found");
                } else {
                    employees.forEach(System.out::println);
                }

                break;

            case 3:

                System.out.println("Enter Employee Id:");
                int id = sc.nextInt();

                System.out.println("Enter Salary Increment:");
                double amount = sc.nextDouble();

                String message = employeeService.raiseSalary(id, amount);
                System.out.println(message);

                break;

            case 4:

                System.out.println("Application Closed");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }
        }
    }
}