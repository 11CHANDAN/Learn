package com.code.service;

import java.util.List;

import com.code.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto dto);
	
	CategoryDto updateCategory(Integer id,CategoryDto dto);
	
	void deleteCategory(Integer id);
	
	List<CategoryDto> getAllCategory();
	
	CategoryDto getCategoryById(Integer id);
}
