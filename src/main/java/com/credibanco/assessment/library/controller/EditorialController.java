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
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.impl.EditorialServiceImpl;

@RestController
public class EditorialController {
	
	private static Logger logger = Logger.getLogger(EditorialController.class);
	
	@Autowired
	private EditorialServiceImpl editorialServiceImpl;
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/registerEditorial")
	public ResponseEntity registerEditorial(@RequestBody Editorial editorial) {
		try {
			// validations
			Map<String, String> validations = new HashMap<String, String>();
					
			if(editorial.getName() == null || editorial.getName().trim().isEmpty()) validations.put("name", "the name is required");
			else if(editorialServiceImpl.findEditorialByName(editorial.getName().trim()) != null) validations.put("editorial", "the editorial is already registered");
			if(editorial.getAddress() == null || editorial.getAddress().trim().isEmpty()) validations.put("address", "the address is required");
			if(editorial.getTelephone() == null || editorial.getTelephone().trim().isEmpty()) validations.put("telephone", "the telephone is required");
			if(editorial.getMaximumNumber() == null || editorial.getMaximumNumber() < -1) validations.put("maximumNumber", "the maximum number of registered books is required");
			
			if(!validations.isEmpty()) return ResponseEntity.status(401).body(validations);
			
			editorial.setCreationDate(new Date());
			
			return ResponseEntity.ok(editorialServiceImpl.createEditorial(editorial));
		} catch (GeneralException e) {
			logger.info(e.getMessage(), e);
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
