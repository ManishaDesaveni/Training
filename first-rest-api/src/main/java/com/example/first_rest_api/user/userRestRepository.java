package com.example.first_rest_api.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface userRestRepository extends PagingAndSortingRepository<UserDetails, Long> {
	List<UserDetails> findByRole(String role);
}
