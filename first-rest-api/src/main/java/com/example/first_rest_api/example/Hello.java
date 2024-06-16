package com.example.first_rest_api.example;

public class Hello {

	private String message;

	public Hello(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Hello [message=" + message + "]";
	}

}
