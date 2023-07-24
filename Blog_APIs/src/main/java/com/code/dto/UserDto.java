package com.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int user_id;
	
	@NotEmpty
	private String name;
	@Email(message="Email address in not valid!!")
	@NotEmpty
	private String email;
	@NotEmpty
	@Size(min=8,message="Password must contain minimum 8 characters")
	private String password;
	@NotEmpty
	private String about;
	
}
