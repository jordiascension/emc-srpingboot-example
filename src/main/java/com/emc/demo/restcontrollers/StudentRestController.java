package com.emc.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emc.demo.model.Student;
import com.emc.demo.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/students", produces = "application/json")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> studentList = studentService.getStudents();

		return ResponseEntity.ok(studentList);
	}

	@GetMapping(path = "/students/{name}", produces = "application/json")
	public ResponseEntity<List<Student>> getStudentsByName(
			@PathVariable("name") String name) {
		List<Student> studentList = studentService.getStudentsByName(name);

		return ResponseEntity.ok(studentList);
	}

	@GetMapping(path = "/students/{name}/{surname}", produces = "application/json")
	public ResponseEntity<List<Student>> getStudentsByNameAndSurname(
			@PathVariable("name") String name,
			@PathVariable("surname") String surname) {
		List<Student> studentList = studentService
				.getStudentsByNameAndSurname(name, surname);

		return ResponseEntity.ok(studentList);
	}

	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student),
				HttpStatus.CREATED);
	}

}
