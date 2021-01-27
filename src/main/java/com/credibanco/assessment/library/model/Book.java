package com.credibanco.assessment.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Book {
	
	@Id
	private Long id;
	
	private Date creationDate;
	
	private String tittle;
	private String year;
	private String gender;
	private Integer numberPages;
	private Editorial editorial;
	private Author author;
	
	private String editorialName;
	private String authorName;
	
	public Book() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the tittle
	 */
	public String getTittle() {
		return tittle;
	}

	/**
	 * @param tittle the tittle to set
	 */
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the numberPages
	 */
	public Integer getNumberPages() {
		return numberPages;
	}

	/**
	 * @param numberPages the numberPages to set
	 */
	public void setNumberPages(Integer numberPages) {
		this.numberPages = numberPages;
	}

	/**
	 * @return the editorial
	 */
	@ManyToOne
	public Editorial getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the author
	 */
	@ManyToOne
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the editorialName
	 */
	@Transient
	public String getEditorialName() {
		return editorialName;
	}

	/**
	 * @param editorialName the editorialName to set
	 */
	public void setEditorialName(String nameEditorial) {
		this.editorialName = nameEditorial;
	}

	/**
	 * @return the authorName
	 */
	@Transient
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
