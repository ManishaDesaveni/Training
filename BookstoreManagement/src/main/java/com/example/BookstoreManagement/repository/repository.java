package com.example.BookstoreManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookstoreManagement.entity.Book;

@Repository
public interface repository extends JpaRepository<Book, Integer> {
	Optional<Book> findById(int id);
}
