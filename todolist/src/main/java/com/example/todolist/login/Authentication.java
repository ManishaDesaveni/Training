package com.example.todolist.login;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
	public boolean authenticationService(String username,String password)
	{
		boolean validname=username.equalsIgnoreCase("manisha");
		boolean validpassword=password.equalsIgnoreCase("1234");
		return validname&&validpassword;
	}

}
