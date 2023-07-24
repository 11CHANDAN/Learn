package com.code.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@NotEmpty
	@Size(min=0,max=100)
	@Column(name="title")
	
	private String categoryTitle;
	
	@Column(name="description")
	private String categoryDerscription;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Post> post;
}
