package com.example.BigData;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="Hello World Project",
				version="1.0.0",
				description = "this project is only for learning",
				termsOfService="runcode"



		)
)

public class BigDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigDataApplication.class, args);
		System.out.println("ok");
	}


}
