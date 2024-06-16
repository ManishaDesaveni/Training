package com.example.BookstoreManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookstoreManagement.entity.Mybook;
import com.example.BookstoreManagement.repository.Mybookrepo;

@Service
public class Mybookservice {

	@Autowired
	private Mybookrepo repo;

	public void savemybook(Mybook b) {
		repo.save(b);
	}

	public List<Mybook> getAll() {
		return repo.findAll();
	}

}
