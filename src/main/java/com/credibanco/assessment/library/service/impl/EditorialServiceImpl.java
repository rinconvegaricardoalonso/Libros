package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.EditorialRepository;
import com.credibanco.assessment.library.service.EditorialService;

@Service
public class EditorialServiceImpl implements EditorialService {
	
	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	public Editorial createEditorial(Editorial editorial) throws GeneralException {
		return editorialRepository.save(editorial);
	}

	@Override
	public Editorial findEditorialByName(String name) throws GeneralException {
		List<Editorial> editorials = (List<Editorial>) editorialRepository.findAll();
		
		return editorials.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

}
