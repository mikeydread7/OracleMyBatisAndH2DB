package com.mybatis.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {

		return new ApiInfo("My REST API", "Some custom description of API can be added here.", "API Stuff",
				"Terms of service is as is",
				new Contact("Michael Somers", "mywww.ibatis-example.com", "mike1somers@gmail.com"), "License of API",
				"API license URL");

	}

}
