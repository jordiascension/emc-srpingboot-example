
package com.emc.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.emc.demo.model.Student;

@DataJpaTest // @AutoConfigureTestDatabase(replace = Replace.NONE) class
public class StudentRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	StudentRepository repository;

	@Test
	void testFindByName() {

		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);

		entityManager.persist(student);
		entityManager.flush();

		List<Student> studentList = repository.findByName("Jordi");
		assertTrue(studentList.size() > 0);

	}

	@Test
	void testFindByNameAndSurname() {
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);

		entityManager.persist(student);
		entityManager.flush();

		List<Student> studentList = repository.findByNameAndSurname("Jordi",
				"Ros");
		assertTrue(studentList.size() > 0);
	}

	@Test
	void testFindByAge() {
		Student student = new Student();
		student.setName("Jordi");
		student.setSurname("Ros");
		student.setAge(24);

		entityManager.persist(student);
		entityManager.flush();

		List<Student> studentList = repository.findByAge(24);
		assertTrue(studentList.size() > 0);

	}
}