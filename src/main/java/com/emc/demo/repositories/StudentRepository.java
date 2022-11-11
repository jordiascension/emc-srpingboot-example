package com.emc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByNameAndSurname(String name, String surname);

}
