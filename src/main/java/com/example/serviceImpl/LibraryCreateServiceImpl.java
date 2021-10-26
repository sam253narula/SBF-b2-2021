package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;
import com.example.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepository createRepository;
	
	@Override
	public String addSingleLibrary(Library library) {
		createRepository.save(library);
		createRepository.flush();
		return "Library saved";
	}
	
	@Override
	public String addAllLibraries(List<Library> libraries) {
//		createRepository.saveAll(libraries);
//		createRepository.flush();
		createRepository.saveAllAndFlush(libraries);
		return "All Libraries are Saved";
	}
	
	@Override
	public Library addLibrararywithSaveAndFlush(Library library) {
		return createRepository.saveAndFlush(library);
	}
}



