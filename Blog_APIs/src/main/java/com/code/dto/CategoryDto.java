package com.code.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	private int categoryId;
	@NotEmpty 
	private String categoryTitle;
	@NotEmpty
	private String categoryDerscription;
}
