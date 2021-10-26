package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentIDWithEmbeddableAnnotation;
import com.example.entity.StudentWithCompositeKeyWithEmbeddableAnnotation;

public interface StudentRepositoryEmbeddable extends JpaRepository<StudentWithCompositeKeyWithEmbeddableAnnotation, StudentIDWithEmbeddableAnnotation> {

}
