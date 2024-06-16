package com.example.BookstoreManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.BookstoreManagement.service.Mybookservice;

@Controller
public class Mybookcontroller {

	@Autowired
	private Mybookservice service;

}
