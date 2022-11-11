package com.emc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.model.Student;
import com.emc.demo.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/*
	 * Get List from Mysql db
	 */
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	public List<Student> getStudentsByNameAndSurname(String name,
			String surname) {
		return studentRepository.findByNameAndSurname(name, surname);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
