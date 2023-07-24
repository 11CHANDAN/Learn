package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
