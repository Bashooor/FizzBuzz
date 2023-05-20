package com.example.FizzBuzz;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class FizzBuzzApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFizzBuzz() throws Exception {
		// test for num > 0
		int num = 15;
		mockMvc.perform(MockMvcRequestBuilders.get("/fizzBuzz/{num}", num))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("1"))		//number 1
			.andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("2"))		//number 2
			.andExpect(MockMvcResultMatchers.jsonPath("$[2]").value("Fizz"))	// number 3
			.andExpect(MockMvcResultMatchers.jsonPath("$[4]").value("Buzz"))	// number 5
			.andExpect(MockMvcResultMatchers.jsonPath("$[14]").value("FizzBuzz")); // number 15
		
		// test for num <= 0
		num = 0;
		mockMvc.perform(MockMvcRequestBuilders.get("/fizzBuzz/{num}", num))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
		
		// test for non-numeric num
		String s = "string";
		mockMvc.perform(MockMvcRequestBuilders.get("/fizzBuzz/{s}", s))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
