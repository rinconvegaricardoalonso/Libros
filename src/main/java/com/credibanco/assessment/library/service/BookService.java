package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Book;

public interface BookService {
	
	public List<Book> findAllBooks() throws GeneralException;
	public Book createBook(Book book) throws GeneralException;
	public List<Book> findBooksByEditorial(String name) throws GeneralException;
	
}
