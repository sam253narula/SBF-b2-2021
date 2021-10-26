package com.example;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.example.entity.Library;
import com.example.model.FullName;
import com.example.model.SpringBootAppInfo;
import com.example.service.LibraryReadService;
import com.example.serviceImpl.ExampleServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootFundamentalsB2Application implements CommandLineRunner {

	@Autowired
	ExampleServiceImpl exampleServiceImpl;

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFundamentalsB2Application.class, args);
		System.out.println("Hello World");
		System.out.println("Hello Markus");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("App info -> {}", SpringBootAppInfo.builder().courseName("SBF").courseType("IT")
				.instrutorName(FullName.builder().firstName("Samarth").lastName("Narula").build()).build());
		log.warn(exampleServiceImpl.get().toString());
		log.info("fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		log.info("fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		log.info("fetch libs -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(1, 4).get().collect(Collectors.toList()));
		log.info("fetch libs sorted in asc by name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		String csb = "xyz, abc, efg";
		log.info("Get Libraries Custom Paged And Sorted By Name And With These Books -> {}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(csb, 0, 2).get()
						.collect(Collectors.toList()));

		Optional<Library> aLibraryById = libraryReadServiceImpl.getALibraryById(1l);
		if (aLibraryById.isPresent()) {
			Library library = aLibraryById.get();
			log.info("Get lib by id -> {}", library);
		} else {
			throw new RuntimeException("There is  no lib with id 1");
		}
		
		log.info("Single Lib with these books -> {}", libraryReadServiceImpl.getALibraryWithTheseBooks("learn java, learn scala, learn AWS"));

	}

}
