package com.cms.application_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
