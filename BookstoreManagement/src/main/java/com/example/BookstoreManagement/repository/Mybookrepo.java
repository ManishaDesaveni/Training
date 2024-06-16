package com.example.BookstoreManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookstoreManagement.entity.Mybook;

@Repository
public interface Mybookrepo extends JpaRepository<Mybook, Integer> {

}
