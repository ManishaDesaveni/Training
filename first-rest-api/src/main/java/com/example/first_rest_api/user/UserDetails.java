package com.example.first_rest_api.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserDetails {

	@Id

	Long id;
	String name;
	String role;

	public UserDetails() {

	}

	public UserDetails(long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
