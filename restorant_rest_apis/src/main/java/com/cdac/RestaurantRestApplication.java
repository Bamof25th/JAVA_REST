package com.cdac;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantRestApplication.class, args);
	}

	@Bean // its a method level annotation non void returning
	public ModelMapper modelMapper() {
		System.out.println("in Model mapper creation");
		return new ModelMapper();
	}
}
