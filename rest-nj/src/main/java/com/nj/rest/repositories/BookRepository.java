package com.nj.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nj.rest.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	

	/*@Query("select b from Book b where b.title = :title")
	public List<Book> findByTitle(@Param("title") String title);*/
	
	
	public List<Book> findByTitle(String title);
	
	
	
	
	
}
