package com.code.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(nullable = false)@NotEmpty
	private String name;
	
	@Email(message = "your email id is not valid") @Column(nullable = false)
	private String email;
	
	@Size(min=8,message="password must contain atleast 8 characters") @NotEmpty
	private String password;
	
	private String about;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
//	private List<Post> post;
}
