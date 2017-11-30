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
//http://server_context_path/swagger-ui.html
//After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder,
//which provides a way to control the endpoints exposed by Swagger
//CODEGEN
//https://github.com/eugenp/tutorials/tree/master/spring-swagger-codegen/spring-swagger-codegen-app/src/main/java/com/baeldung/petstore/app

@Configuration
@EnableSwagger2
public class SwaggerConfig  {  
	
	@Bean
	public Docket api() {
		
		/*final List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
	    responseMessageList
	        .add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build());

	    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	        .paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
	        .globalResponseMessage(RequestMethod.GET, responseMessageList);*/
		 return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	 
	}
   
	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {
		
		return new ApiInfo("My REST API", 
				"Some custom description of API can be added here.",
				"API Stuff",
				"Terms of service is as is",
				new Contact("Michael Somers", 
						"mywww.ibatis-example.com", 
						"mike1somers@gmail.com"
						), 
				"License of API",
				"API license URL"
				);
		
	}
    
}
