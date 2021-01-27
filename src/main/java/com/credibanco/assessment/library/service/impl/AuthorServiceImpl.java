package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.repository.AuthorRepository;
import com.credibanco.assessment.library.service.AuthorService;
import com.credibanco.assessment.library.exceptions.GeneralException;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author createAuthor(Author author) throws GeneralException {
		return authorRepository.save(author);
	}

	@Override
	public Author findAuthorByName(String name) throws GeneralException {
		List<Author> authors = (List<Author>) authorRepository.findAll();
		
		return authors.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

}
