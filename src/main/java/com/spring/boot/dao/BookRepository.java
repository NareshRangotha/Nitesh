package com.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>
{
	public Book findById(int id);

}
