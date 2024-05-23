package com.example.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Sayhello {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello()
	{
		return "welcome to this spring";
	}
	
	
	
	@RequestMapping("say-hello-jsp")
	public String sayhellojsp()
	{
		return "welcome";
	}


}
