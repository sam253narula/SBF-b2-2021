package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;
import com.example.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}

	@Override
	public long countLibrariesWithZeroBooks() {
		Library library = new Library();
		library.setCommaSeperatedBooknames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}

}










