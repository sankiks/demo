package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.apache.el.parser.AstIdentifier;
import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner (StudentRepository repository){
		return args ->{
			Student mariamStudent = new Student(
					
					"Mariam",
					"mariam.jamal@gmail.com",
					LocalDate.of(2000, Month.JANUARY,5),
					21
					);
		
		Student bajramStudent = new Student(
				
				"Bariam",
				"Bariam.jamal@gmail.com",
				LocalDate.of(2100, Month.JANUARY,5),
				21
				);
		repository.saveAll(List.of(mariamStudent, bajramStudent));
	};
	}

}
