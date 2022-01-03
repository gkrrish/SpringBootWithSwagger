package com.example.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	String regexPattern = "/example.*";

	@Bean
	public Docket exampleApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.app.controller")).build();
	}
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("example Restuarant API")
				.description("Provides the API for example Resturant Application")
				.version("1.0").build();
	}

}
