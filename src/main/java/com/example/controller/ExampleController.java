package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SpringBootAppInfo;
import com.example.service.ExampleService;

import io.swagger.annotations.ApiOperation;

//@Controller
@RestController
public class ExampleController {

	@Autowired
	ExampleService exampleService;

	@ApiOperation(value = "Provides information about this course")
	@GetMapping("/info")
	// @ResponseBody
	public SpringBootAppInfo get() {
		return exampleService.get();
	}

	@ApiOperation(value = "Allows you to customize information about a course")
	@PostMapping("/customInfo")
	public SpringBootAppInfo customInfo(String courseName, String courseType, String firstName, String lastName) {
		return exampleService.customInfo(courseName, courseType, firstName, lastName);
	}

}
