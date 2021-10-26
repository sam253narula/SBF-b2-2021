package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentID;
import com.example.entity.StudentWithCompositeKeyWithIDClassAnnotation;

public interface StudentRepositoryIdClass extends JpaRepository<StudentWithCompositeKeyWithIDClassAnnotation, StudentID> {

}
