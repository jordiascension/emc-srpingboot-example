package com.emc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
