package com.credibanco.assessment.library.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.service.impl.AuthorServiceImpl;

@RestController
public class AuthorController {
	
	private static Logger logger = Logger.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/registerAuthor")
	public ResponseEntity registerAuthor(@RequestBody Author author) {
		try {
			// validations
			Map<String, String> validations = new HashMap<String, String>();
			
			if(author.getName() == null || author.getName().trim().isEmpty()) validations.put("name", "the name is required");
			else if(authorServiceImpl.findAuthorByName(author.getName().trim()) != null) validations.put("author", "the author is already registered");
			
			if(!validations.isEmpty()) return ResponseEntity.status(401).body(validations);
			
			author.setCreationDate(new Date());
			
			return ResponseEntity.ok(authorServiceImpl.createAuthor(author));
		} catch (GeneralException e) {
			logger.info(e.getMessage(), e);
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
