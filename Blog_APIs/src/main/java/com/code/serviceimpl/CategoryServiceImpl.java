package com.code.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dto.CategoryDto;
import com.code.entity.Category;
import com.code.exception.ResourceNotFoundException;
import com.code.repository.CategoryRepository;
import com.code.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository repo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto dto) {
		Category cat=this.dtoToCategory(dto);
		Category c1=this.repo.save(cat);
		return this.categoryToDto(c1);
	}

	@Override
	public CategoryDto updateCategory(Integer id, CategoryDto dto) {
		Category cat=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", id));
		cat.setCategoryTitle(dto.getCategoryTitle());
		cat.setCategoryDerscription(dto.getCategoryDerscription());
		Category dto1=repo.save(cat);
		return categoryToDto(cat);
	}

	@Override
	public void deleteCategory(Integer id) {
		Category cat=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", id));
		repo.delete(cat);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> category=repo.findAll();
		List<CategoryDto> categoryDto=category.stream().map(c -> categoryToDto(c)).collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category c=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", id));
		CategoryDto cat=categoryToDto(c);
		return cat;
	}
	
	public Category dtoToCategory(CategoryDto c) {
		return mapper.map(c, Category.class);
	}
	
	public CategoryDto categoryToDto(Category c) {
		return mapper.map(c, CategoryDto.class);
	}
}
