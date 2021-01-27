package com.credibanco.assessment.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.library.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
