package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private List<Student> students = new ArrayList<>();
	public StudentController() {
		students.add(new Student(1, "Anand"));
		students.add(new Student(2, "Ravi"));
	}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		for (Student s : students) {
			if (s.getId() == id) {
				return s;
			}
		}
		throw new StudentNotFoundException("Student now found with id " + id);
	}
}
