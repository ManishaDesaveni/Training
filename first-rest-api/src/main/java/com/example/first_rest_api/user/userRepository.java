package com.example.first_rest_api.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<UserDetails, Long> {
	List<UserDetails> findByname(String name);
}
