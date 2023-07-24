package com.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.Category;
import com.code.entity.Post;
import com.code.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
