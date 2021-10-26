package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.StudentWithCompositeKeyWithEmbeddableAnnotation;
import com.example.entity.StudentWithCompositeKeyWithIDClassAnnotation;
import com.example.repository.StudentRepositoryEmbeddable;
import com.example.repository.StudentRepositoryIdClass;

@RestController
public class StudentWithCompositeKeyController {

	// Below is demo of @IdClass
	@Autowired
	StudentRepositoryIdClass idClassRepo;
	
	@PostMapping("/addStudentForIdClass")
	public void addStudent(StudentWithCompositeKeyWithIDClassAnnotation student) {
		idClassRepo.saveAndFlush(student);
	}
	
	@GetMapping("/getStudentForIdClass")
	public List<StudentWithCompositeKeyWithIDClassAnnotation> getStudentForIdClass() {
		return idClassRepo.findAll();
	}
	
	// Below is demo of @Embeddable
	@Autowired
	StudentRepositoryEmbeddable embeddableRepo;
	
	@PostMapping("/addStudentForEmbeddable")
	public void addStudent(StudentWithCompositeKeyWithEmbeddableAnnotation student) {
		embeddableRepo.saveAndFlush(student);
	}
	
	@GetMapping("/getStudentForEmbeddable")
	public List<StudentWithCompositeKeyWithEmbeddableAnnotation> getStudentForEmbeddable() {
		return embeddableRepo.findAll();
	}
	
	 
	
}
