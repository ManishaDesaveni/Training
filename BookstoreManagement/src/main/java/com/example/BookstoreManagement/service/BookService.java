package com.example.BookstoreManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookstoreManagement.entity.Book;
import com.example.BookstoreManagement.repository.repository;

@Service
public class BookService {

	@Autowired
	private repository repo;

	public void savebook(Book b) {
		repo.save(b);
	}

	public List<Book> getbooklist() {
		List<Book> list = repo.findAll();
		return list;
	}

	public Book getElementById(int id) {
		Optional<Book> book = repo.findById(id);
		return book.orElse(null); // Handle the case where the book is not found
	}

}
