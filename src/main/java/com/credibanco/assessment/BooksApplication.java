package com.credibanco.assessment;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.controller.AuthorController;
import com.credibanco.assessment.library.controller.BookController;
import com.credibanco.assessment.library.controller.EditorialController;

@SpringBootApplication
@RestController
public class BooksApplication {
	
	private static Logger logger = Logger.getLogger(BooksApplication.class);
	
	public static void main(String[] args) {
		logger.info("Starting...");
		
		SpringApplication.run(BooksApplication.class, args);
		SpringApplication.run(BookController.class, args);
		SpringApplication.run(AuthorController.class, args);
		SpringApplication.run(EditorialController.class, args);
	}
	
}
