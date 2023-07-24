package com.code.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.dto.UserDto;
import com.code.payloads.ApiResponse;
import com.code.serviceimpl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/api")
public class UserController 
{
	@Autowired
	UserServiceImpl serviceImpl;
	
	//POST -create user
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto dto){
		return new ResponseEntity<UserDto>(serviceImpl.createUser(dto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{userID}")
	ResponseEntity<UserDto> updateUser(@Valid @PathVariable("userID") Integer id,@RequestBody UserDto dto){
		return new ResponseEntity<UserDto>(serviceImpl.updateUser(dto, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userID}")
	ResponseEntity<ApiResponse> deleteUser(@RequestParam Integer uid){
		serviceImpl.deleteUserById(uid);
//		return ResponseEntity.ok(Map.of("message","User deleted successfully"));
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/users")
	ResponseEntity<List<UserDto>> getAllUser(@RequestParam(defaultValue = "0",required = false) Integer pageNumber,@RequestParam(defaultValue = "5",required = false) Integer pageSize){
		return new ResponseEntity<List<UserDto>>(serviceImpl.getAllUser(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/{userID}")
	ResponseEntity<UserDto> getSingleUse(@RequestHeader Integer id){
		return new ResponseEntity<UserDto>(serviceImpl.getUserById(id),HttpStatus.OK);
	}
	
}
