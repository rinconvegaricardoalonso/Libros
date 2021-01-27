package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Author;

public interface AuthorService {
	
	public Author createAuthor(Author author) throws GeneralException;
	public Author findAuthorByName(String name) throws GeneralException;
	
}
