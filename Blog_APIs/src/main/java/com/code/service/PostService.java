package com.code.service;

import java.util.List;

import com.code.dto.PostDto;

public interface PostService {
	PostDto createPost(PostDto dto,Integer userId,Integer categoryId);
	
	PostDto updatePostById(Integer id,PostDto dto);
	
	List<PostDto> getPostByCategory(Integer id);
	
	List<PostDto> getPostByUser(Integer id);
	
	List<PostDto> getAllPosts(Integer pageNumber,Integer pageSize);
	
	PostDto getPostById(Integer id);
	
	void deletePostById(Integer id);
}
