package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	

	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
		
	}
	
	@PostMapping
	public int addNewStudent(@RequestBody Student student) {
		this.studentService.addNewStudent(student);
		return 1;
	}
	
	@DeleteMapping(path = "{id}")

	public void deleteStudent(@PathVariable("id") Long jj) {
		studentService.deleteStudent(jj);
	}
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

}
