package com.example.service;

import java.util.List;

import com.example.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibrararywithSaveAndFlush(Library library);

}