package com.example.Crudoperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crudoperations.entity.Product;
import com.example.Crudoperations.repository.Productrepository;

@Service
public class productservice {

	@Autowired
	private Productrepository repo;

	public Product saveproduct(Product product) {
		return repo.save(product);
	}

	public List<Product> saveAll(List<Product> products) {
		return repo.saveAll(products);
	}

	public List<Product> getAll() {
		return repo.findAll();
	}

	public Product getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Product getByName(String Name) {
		return repo.findByName(Name).orElse(null);
	}

	public Product updateproduct(Product product) {
		Product prod = repo.findById(product.getId()).orElse(null);
		prod.setName(product.getName());
		prod.setQuantity(product.getQuantity());
		prod.setPrice(product.getPrice());
		return repo.save(prod);
	}

	public String deleteId(int id) {
		repo.deleteById(id);
		return "product removed" + id;
	}
}
