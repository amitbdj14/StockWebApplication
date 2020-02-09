package com.api.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class StockMainApp extends WebMvcConfigurerAdapter {
	String str1;
	String str2;
	String str4;

	String str5;
	
	public static void main(String[] args) {
		SpringApplication.run(StockMainApp.class, args);
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass()
						.getPackage().getName())).paths(PathSelectors.any())
				.build().apiInfo(generateApiInfo());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("**/swagger-ui.html").addResourceLocations(
				"classpath:/META-INF/resources/");
		registry.addResourceHandler("**/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo generateApiInfo() {
		return new ApiInfo(
				"Stock Web Application",
				"This service display list of stocks on hitting http://localhost:8080/stocks URL and we can also check the results for GET POST and PUT http methods on Swagger UI ",
				"Stock Web Application version 1.0", "urn:tos",
				"Stock Web Application Developer", "Apache 2.0+Spring Boot",
				"http://www.apache.org/licenses/LICENSE-2.0");
	}
}
