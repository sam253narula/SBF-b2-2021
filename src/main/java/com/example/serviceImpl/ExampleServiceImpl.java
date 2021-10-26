package com.example.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.model.FullName;
import com.example.model.SpringBootAppInfo;
import com.example.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public SpringBootAppInfo get() {
		log.info("Inside get() method");
		SpringBootAppInfo springBootAppInfo = new SpringBootAppInfo();
		springBootAppInfo.setCourseName("Learn Controllers in Spring boot");
		springBootAppInfo.setCourseType("Information Technology");
		springBootAppInfo.setInstrutorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		return springBootAppInfo;
	}

	@Override
	public SpringBootAppInfo customInfo(String courseName, String courseType, String firstName, String lastname) {
		log.info("Inside customInfo() method");
		SpringBootAppInfo springBootAppInfo = new SpringBootAppInfo();
		springBootAppInfo.setCourseName(courseName);
		springBootAppInfo.setCourseType(courseType);
		springBootAppInfo.setInstrutorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		return springBootAppInfo;
	}

}
