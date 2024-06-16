package com.example.BookstoreManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookstoreManagement.entity.Book;
import com.example.BookstoreManagement.entity.Mybook;
import com.example.BookstoreManagement.service.BookService;
import com.example.BookstoreManagement.service.Mybookservice;

@Controller
public class controller {

	@Autowired
	private BookService services;

	@Autowired
	private Mybookservice service;

	@GetMapping("/")
	public String homepage() {
		return "home";
	}

	@GetMapping("/register")
	public String bookregister() {
		return "register";
	}

	@PostMapping("/savebook")
	public String savebook(@ModelAttribute Book b) {

		services.savebook(b);
		return "redirect:/available_books";
	}

	@GetMapping("/available_books")
	public String booklist(ModelMap model) {
		List<Book> books = services.getbooklist();
		model.addAttribute("books", books);
		return "availablebooks";

	}

	@GetMapping("/addmybook/{id}")
	public String savemybook(@PathVariable("id") int id) {
		Book book = services.getElementById(id);
		if (book != null) {
			Mybook reqbook = new Mybook(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
			service.savemybook(reqbook);
		}
		return "redirect:/mybooklist";
	}

	@GetMapping("/mybooklist")
	public String mybooklist(ModelMap model) {
		List<Mybook> list = service.getAll();
		model.addAttribute("books", list);
		return "mybookdata";
	}

}
