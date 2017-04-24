package com.nj.rest.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.nj.rest.entities.Author;
import com.nj.rest.entities.Book;

public class BookUtil {

	private static String[] titles = { "Spring In Action", "1984", "Hibernate Recipes", "Java Complete Reference",
			"Manning Spring4", "On The Road", "Catch 22", "To Kill A Mockingbird", "Brave New World",
			"The Scarlet Letter" };

	public static List<Book> create(int size) {
		List<Book> books = new LinkedList<Book>();
		for (int x = 0; x < size; x++) {
			books.add(BookUtil.create());
		}
		return books;
	}

	public static Book create() {
		Book book = new Book();
		book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length)]);
		book.setPageCount(ThreadLocalRandom.current().nextInt(100, 151));
		book.setPublishDate(new Date());
		book.setPrice(new BigDecimal("15.00"));
		Author author = new Author();
		author.setFirstName("Nithin");
		author.setLastName("Jayan");
		author.setCountry("India");
		book.setAuthor(author);
		return book;
	}
	
}
