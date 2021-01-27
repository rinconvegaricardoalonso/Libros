package com.credibanco.assessment.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.impl.AuthorServiceImpl;
import com.credibanco.assessment.library.service.impl.BookServiceImpl;
import com.credibanco.assessment.library.service.impl.EditorialServiceImpl;

@RestController
public class BookController {
	
private static Logger logger = Logger.getLogger(BookController.class);
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	
	@Autowired
	private EditorialServiceImpl editorialServiceImpl;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("getAllBooks")
	public ResponseEntity getAllBooks() {
		try {
			return ResponseEntity.ok(bookServiceImpl.findAllBooks());
		} catch (GeneralException e) {
			logger.info(e.getMessage(), e);
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/registerBook")
	public ResponseEntity registerBook(@RequestBody Book book) {
		try {
			// validations
			Map<String, String> validations = new HashMap<String, String>();
			
			if(book.getTittle() == null || book.getTittle().trim().isEmpty()) validations.put("tittle", "the tittle is required");
			if(book.getGender() == null || book.getGender().trim().isEmpty()) validations.put("gender", "the gender is required");
			if(book.getNumberPages() == null || book.getNumberPages() <= 0) validations.put("numberPages", "the number of pages is required");
			if(book.getAuthorName() == null || book.getAuthorName().trim().isEmpty()) validations.put("authorName", "the author name is required");
			else if(authorServiceImpl.findAuthorByName(book.getAuthorName().trim()) == null) validations.put("authorName", "the author is not registered");
			if(book.getEditorialName() != null) {
				Editorial editorial = editorialServiceImpl.findEditorialByName(book.getEditorialName().trim());
				
				if(editorial == null) validations.put("editorialName", "the editorial is not registered");
				else if(editorial.getMaximumNumber() > -1) {
					if(editorial.getMaximumNumber() == 0) validations.put("editorialName", "maximum number of books allowed for the same editorial");
					else {
						List<Book> books = bookServiceImpl.findBooksByEditorial(editorial.getName());
					
						if(books.size() == editorial.getMaximumNumber()) validations.put("editorialName", "maximum number of books allowed for the same editorial");
					}
				}
			}
			
			if(!validations.isEmpty()) return ResponseEntity.status(401).body(validations);
			
			book.setCreationDate(new Date());
			book.setAuthor(authorServiceImpl.findAuthorByName(book.getAuthorName().trim()));
			if(book.getEditorialName() != null) book.setEditorial(editorialServiceImpl.findEditorialByName(book.getEditorialName().trim()));
			
			return ResponseEntity.ok(bookServiceImpl.createBook(book));
		} catch (GeneralException e) {
			logger.info(e.getMessage(), e);
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
	}

}
