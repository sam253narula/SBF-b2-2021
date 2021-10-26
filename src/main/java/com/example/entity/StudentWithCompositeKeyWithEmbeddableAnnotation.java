package com.example.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class StudentWithCompositeKeyWithEmbeddableAnnotation {
	
	@EmbeddedId
	StudentIDWithEmbeddableAnnotation studentId;
	
	private String name;
}
