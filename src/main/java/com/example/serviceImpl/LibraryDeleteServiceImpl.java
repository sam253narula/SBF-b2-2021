package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;
import com.example.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted Library: " + library;
	}

	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "prune complete";
	}

	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete All Complete";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted All in Batch Completed";
	}

	@Override
	public String deleteLibraryById(Long id) {
		if(libraryRepository.existsById(id))
		libraryRepository.deleteById(id);
		else
			throw new RuntimeException("There is no lib with this ID");
		return "Library with id: " + id + " is deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Deleted all the libraries in the list in batch mode";
	}

}
