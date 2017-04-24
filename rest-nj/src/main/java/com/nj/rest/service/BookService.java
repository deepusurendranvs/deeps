package com.nj.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nj.rest.entities.Book;
import com.nj.rest.repositories.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public void save(Book book){
		this.repo.save(book);
	}
	
	public void save(List<Book> bookList){
		this.repo.save(bookList);
	}
	
	public List<Book> getBookByTitle(String title){
		return this.repo.findByTitle(title);
	}
}
