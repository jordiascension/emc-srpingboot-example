package com.emc.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.emc.demo.model.Student;

@Controller
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/studentList")
	public String getStudents(Model model) {

		String fooResourceUrl = "https://emc-test-jordi.herokuapp.com/student/students";

		/*
		 * if (System.getenv("DYNO") == null) { fooResourceUrl =
		 * "https://emc-test-jordi.herokuapp.com/student/students"; } else {
		 * fooResourceUrl = "http://localhost:8080/student/students"; }
		 */
		ResponseEntity<Student[]> response = restTemplate
				.getForEntity(fooResourceUrl, Student[].class);
		Student[] studentsArray = response.getBody();

		List<Student> studentList2 = Arrays.asList(studentsArray);
		model.addAttribute("students", studentList2);

		return "showStudents";

	}
}
