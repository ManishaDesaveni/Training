package com.example.first_rest_api.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

	@RequestMapping("/hello-world/{name}/message")
	public Hello helloworld(@PathVariable String name) {
		return new Hello("hello" + name);
	}

}
