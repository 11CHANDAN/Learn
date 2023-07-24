package com.code.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.code.dto.UserDto;
import com.code.serviceimpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {
	
//	@Mock
//	private UserServiceImpl impl;
//	
//	@InjectMocks
//	private UserController controller;
//	
//	@Test
//	public void testSaveUser() {
//		UserDto userDto=new UserDto();
//		userDto.setEmail("chandan@gmail.com");
//		userDto.setPassword("12345678");
//		userDto.setName("chandan");
//		userDto.setAbout("kjsjdcjgc");
//		
//		Mockito.when(impl.createUser(userDto)).thenReturn(userDto);
//		
//		ResponseEntity<UserDto> entity=controller.saveUser(userDto);
//		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
//	}
	
}
