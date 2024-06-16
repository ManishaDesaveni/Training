package com.example.admin_userapp.service;

import com.example.admin_userapp.dto.UserDto;
import com.example.admin_userapp.model.User;

public interface UserService {

	User save(UserDto userDto);

}
