package com.example.FizzBuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication

// with @RestController we create a RESTful web service
@RestController
public class FizzBuzzApplication {

	public static void main(String[] args) {

		SpringApplication.run(FizzBuzzApplication.class, args);
	}

	/*
	 * Map a GET request with URL path "localhost:8080/fizzBuzz/{num}",
	 * where {num} will be extracted and used in the method fizzBuzz.
	 */
	@GetMapping("/fizzBuzz/{num}")
	public List<String> fizzBuzz(@PathVariable int num) {

		// the number should be positive > 0, because the list should start with 1
		if (num <= 0) {
			return Collections.emptyList();
		}

		// the output list (first it is empty)
		List<String> ls = new ArrayList<>();

		// looping over all numbers from 1 to num
		for (int i=1; i<=num; i++) {

			// if i is divisible by 3 and 5, "FizzBuzz" should be added to the list
			if (i % 3 == 0 && i % 5 == 0) {
				ls.add("FizzBuzz");
			}
			// if i is only divisible by 3, "Fizz" should be added to the list
			else if (i % 3 == 0) {
				ls.add("Fizz");
			}
			// if i is only divisible by 5, "Buzz" should be added to the list
			else if (i % 5 == 0) {
				ls.add("Buzz");
			}
			// otherwise i should be added to the list
			else {
				ls.add(String.valueOf(i));
			}
		}
		return ls;
	}

}