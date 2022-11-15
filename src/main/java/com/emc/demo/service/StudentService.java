package com.emc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.demo.exception.ResourceNotFoundException;
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

	public List<Student> getStudentsByAge(int age) {
		return studentRepository.findByAge(age);
	}

	public Student getStudentsById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.get();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student)
			throws ResourceNotFoundException {

		Optional<Student> oldStudent = studentRepository
				.findById(student.getIdstudent());

		if (!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		} else {
			Student studentToUpdate = oldStudent.get();
			studentToUpdate.setName(student.getName());
			studentToUpdate.setSurname(student.getSurname());
			studentToUpdate.setAge(student.getAge());
			Student updatedStudent = studentRepository.save(studentToUpdate);
			return updatedStudent;
		}
	}

}
