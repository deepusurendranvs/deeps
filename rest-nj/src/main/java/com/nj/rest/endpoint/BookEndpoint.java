package com.nj.rest.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nj.rest.entities.Book;
import com.nj.rest.service.BookService;
import com.nj.rest.util.BookUtil;


@RestController
@RequestMapping(value = "/books")
class BookEndpoint {

    private final BookService bookService;

    @Autowired
    BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }



    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET, value = "/book/title/{title}")
    ResponseEntity<List> getBook(@PathVariable String title) {
    	
    	List<Book> booklist = this.bookService.getBookByTitle(title);
    	HttpStatus status = booklist != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    	return new ResponseEntity<>(booklist ,status);    	 
       
    }
    
    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET, value = "/book/{noOfbooks}")
    ResponseEntity<List> addBook(@PathVariable Integer noOfbooks) {
    	List<Book> books = BookUtil.create(noOfbooks);		
    	bookService.save(books);
        return new ResponseEntity<>(books, HttpStatus.CREATED);
    }

   
}
