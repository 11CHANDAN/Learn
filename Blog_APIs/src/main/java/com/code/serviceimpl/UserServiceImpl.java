package com.code.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.code.dto.UserDto;
import com.code.entity.User;
import com.code.exception.ResourceNotFoundException;
import com.code.repository.UserRepo;
import com.code.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto user) {
		User user1=mapper.map(user, User.class);
		User savedUser=repo.save(user1);
		UserDto dto= mapper.map(savedUser, UserDto.class);
		return dto;
	}
	
	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer id) {
		User user1=this.repo.findById(id).orElse(null);
		if(user1!=null) {
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setAbout(user.getAbout());
			User u1=repo.save(user1);
			return this.userToDto(u1);	
		}
		throw new ResourceNotFoundException("User", "user_id", id);
	}

	@Override
	public UserDto getUserById(Integer id) {
		User u=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "user_id", id));
		UserDto dto = this.userToDto(u);
		return dto;
	}

	@Override
	public List<UserDto> getAllUser(Integer pageNumber,Integer pageSize) {
		
		Pageable p=PageRequest.of(pageNumber, pageSize);
		
		Page<User> allUser=repo.findAll(p);
		
		List<User> user=allUser.getContent();
		
		List<UserDto> dto=user.stream().map(u -> this.userToDto(u)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public void deleteUserById(Integer id) {
		User u1=repo.findById(id).orElse(null);
		if(u1!=null) {
			repo.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("user", "user_id", id);
		}
		
	}
	
	
	public UserDto userToDto(User u) {
		UserDto dto=mapper.map(u, UserDto.class);
//		dto.setId(u.getUser_id());
//		dto.setName(u.getName());
//		dto.setEmail(u.getEmail());
//		dto.setPassword(u.getPassword());
//		dto.setAbout(u.getAbout());
		return dto;
	}

}
