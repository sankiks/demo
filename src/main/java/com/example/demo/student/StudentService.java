package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();

	}

	public void addNewStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> studentbyEmail= studentRepository.findStudentByEmail(student.getEmail());
		System.out.print(student);
		if (studentbyEmail.isPresent()) {
			throw new IllegalStateException("Email taken");
			
			
		}
		studentRepository.save(student);
		this.studentRepository.save(student);

	}
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
