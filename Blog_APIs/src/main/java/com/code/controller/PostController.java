package com.code.controller;

import java.util.List;

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

import com.code.dto.PostDto;
import com.code.payloads.ApiResponse;
import com.code.serviceimpl.PostServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/post/api")
public class PostController {
	
	@Autowired
	PostServiceImpl serviceImpl;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto dto ,@PathVariable Integer userId,@PathVariable Integer categoryId){
		return new ResponseEntity<PostDto>(serviceImpl.createPost(dto, userId, categoryId),HttpStatus.CREATED);
	}
	
	@GetMapping("/category/categoryId")
	ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable  Integer categoryId){
		return new ResponseEntity<List<PostDto>>(serviceImpl.getPostByCategory(categoryId),HttpStatus.OK);
	}
	
	@GetMapping("/user/userId")
	ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer id){
		return new ResponseEntity<List<PostDto>>(serviceImpl.getPostByUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	ResponseEntity<List<PostDto>> getAllPosts(@RequestParam( value="pageNumber",defaultValue = "0",required = false)Integer pageNumber,
											   @RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize){
		return new ResponseEntity<List<PostDto>>(serviceImpl.getAllPosts(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/post/postId")
	ResponseEntity<PostDto> getPostById(@PathVariable Integer postid){
		return new ResponseEntity<PostDto>(serviceImpl.getPostById(postid),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePost")
	ResponseEntity<ApiResponse> deletePostById(@RequestParam Integer post_id){
		serviceImpl.deletePostById(post_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	@PutMapping("/updatePost")
	ResponseEntity<PostDto> updatePostById(@RequestHeader Integer id,@RequestBody PostDto dto){
		return new ResponseEntity<PostDto>(serviceImpl.updatePostById(id, dto),HttpStatus.OK);
	}
	
}
