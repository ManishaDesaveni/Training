package com.example.Crudoperations.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Crudoperations.entity.Product;

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByName(String name);

}
