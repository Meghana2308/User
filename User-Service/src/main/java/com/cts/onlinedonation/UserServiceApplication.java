package com.cts.onlinedonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@Configuration
@EnableSwagger2
public class UserServiceApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Bean
    Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
			.paths(PathSelectors.ant("/donations/**"))
			.build();
		
			
	}
	

}
