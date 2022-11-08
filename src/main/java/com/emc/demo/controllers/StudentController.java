package com.emc.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emc.demo.model.Student;
import com.emc.demo.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/students", produces = "application/json")
	@CrossOrigin
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> studentList = studentService.getStudents();

		return ResponseEntity.ok(studentList);
	}

}
