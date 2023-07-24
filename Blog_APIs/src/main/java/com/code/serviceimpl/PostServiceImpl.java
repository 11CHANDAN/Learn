package com.code.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.code.dto.PostDto;
import com.code.entity.Category;
import com.code.entity.Post;
import com.code.entity.User;
import com.code.exception.ResourceNotFoundException;
import com.code.repository.CategoryRepository;
import com.code.repository.PostRepository;
import com.code.repository.UserRepo;
import com.code.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepo userRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PostDto createPost(PostDto dto, Integer userId, Integer categoryId) {
		
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userid", userId));

		Category category=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryid", categoryId));
		
		Post post=this.mapper.map(dto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepository.save(post);
		
		return this.mapper.map(newPost, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer id) {
		
		Category cat=categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", id));
		
		List<Post> posts = postRepository.findByCategory(cat);
		
		List<PostDto> dtos=posts.stream().map((post)->mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer id) {
		
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "userId",id));
		
		List<Post> posts = postRepository.findByUser(user);
		
		List<PostDto> dtos=posts.stream().map((u)->mapper.map(u, PostDto.class )).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public List<PostDto> getAllPosts(Integer pageNumber,Integer pageSize) {
		
		Pageable p=PageRequest.of(pageNumber, pageSize);
		
		Page<Post> pagePost = postRepository.findAll(p);
		
		List<Post> allPosts = pagePost.getContent();
				
		List<PostDto> dtos=allPosts.stream().map((post)->mapper.map(post, PostDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public PostDto getPostById(Integer id) {
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", id));
		PostDto dto=mapper.map(post, PostDto.class);
		return dto;
	}

	@Override
	public void deletePostById(Integer id) {
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "postid", id));
		postRepository.delete(post);
	}

	@Override
	public PostDto updatePostById(Integer id, PostDto dto) {
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "postid", id));
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setImageName(dto.getImageName());
		post.setAddedDate(new Date());
		
		Post newpost=postRepository.save(post);
		return mapper.map(newpost, PostDto.class);
	}
	
}
