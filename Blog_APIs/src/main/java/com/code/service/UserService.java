package com.code.service;

import java.util.List;

import com.code.dto.UserDto;
import com.code.entity.User;

public interface UserService  {
	
	User saveUser(User user);
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser(Integer pageNumber,Integer pageSize);
	
	void deleteUserById(Integer id);
	
}
