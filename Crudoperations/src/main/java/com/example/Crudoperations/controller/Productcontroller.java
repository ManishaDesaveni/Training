package com.example.Crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Crudoperations.entity.Product;
import com.example.Crudoperations.service.productservice;

@RestController
public class Productcontroller {

	@Autowired
	private productservice service;

	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product) {
		return service.saveproduct(product);
	}

	@PostMapping("/addproducts")
	public List<Product> addproducts(@RequestBody List<Product> product) {
		return service.saveAll(product);
	}

	@GetMapping("/products")
	public String getAllprod(ModelMap model) {

		List<Product> product = service.getAll();
		model.addAttribute("products", product);
		return "productlist";
	}

	@GetMapping("/product/{id}")
	public Product getById(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/products/{name}")
	public Product getByName(@PathVariable String name) {
		return service.getByName(name);
	}

	@PutMapping("/update")
	public Product update(@RequestBody Product product) {
		return service.updateproduct(product);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteId(id);
	}

}
