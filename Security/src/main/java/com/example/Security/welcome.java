package com.example.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

	@GetMapping("/message")
	@ResponseBody
	public String welcomepage() {
		return "hello";
	}

}
