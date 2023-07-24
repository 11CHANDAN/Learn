package com.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
	
	Calculator calculator=new Calculator();
	
	@Test
	void sum() {
		assertThat(calculator.sum(4, 0)).isEqualTo(4);
	}
	@Test
	void prod() {
		assertThat(calculator.prod(2, 2)).isEqualTo(4);
	}
	@Test
	void equi() {
		assertThat(calculator.equal(0, 0)).isTrue();
	}
	
}
