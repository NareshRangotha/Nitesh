package com.spring.boot.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.dao.BookRepository;
import com.spring.boot.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
 
//	get all books
	public List<Book> getAllBooks() {
		List<Book> findAll = (List<Book>) this.bookRepository.findAll();
		return findAll;
	}

//	get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return book;
	}

//	Adding the book
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

//	Delete Book
	public void deleteBook(int id) {
		bookRepository.deleteById(id);

	}

//	Update Book
	public void updateBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);
	}

}
