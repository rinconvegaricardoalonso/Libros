package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.exceptions.GeneralException;
import com.credibanco.assessment.library.model.Editorial;

public interface EditorialService {
	
	public Editorial createEditorial(Editorial editorial) throws GeneralException;
	public Editorial findEditorialByName(String name) throws GeneralException;
	
}
