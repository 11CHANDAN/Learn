package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dto.CategoryDto;
import com.code.entity.Category;
import com.code.payloads.ApiResponse;
import com.code.serviceimpl.CategoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category/api")
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl serviceImpl;
	
	@PostMapping("/addCategory")
	ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto dto){
		return new ResponseEntity<CategoryDto>(serviceImpl.createCategory(dto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{categorryid}")
	ResponseEntity<CategoryDto> updateCategory(@Valid @RequestHeader Integer id,@RequestBody CategoryDto c){
		return new ResponseEntity<CategoryDto>(serviceImpl.updateCategory(id, c),HttpStatus.OK);
	}
	
	@GetMapping("/{categoryid}")
	ResponseEntity<CategoryDto> getCategoryById(@RequestHeader Integer id){
		return new ResponseEntity<CategoryDto>(serviceImpl.getCategoryById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCategory")
	ResponseEntity<List<CategoryDto>> getAllCategory(){
		return new ResponseEntity<List<CategoryDto>>(serviceImpl.getAllCategory(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryid}")
	ResponseEntity<ApiResponse> deleteCategory(@RequestHeader Integer id){
		serviceImpl.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
	}
	
}
