package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.repository.BookRepository;
import com.credibanco.assessment.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAllBooks() throws GeneralException {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book createBook(Book book) throws GeneralException {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findBooksByEditorial(String name) throws GeneralException {
		List<Book> books = (List<Book>) bookRepository.findAll();
		
		return books.stream().filter(x -> x.getEditorial() != null && x.getEditorial().getName().trim().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

}
