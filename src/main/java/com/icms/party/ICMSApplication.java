package com.icms.party;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.service.Contact;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ICMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICMSApplication.class, args);
	}

	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/student/**")).build()

				.apiInfo(new ApiInfo("Party API Documentation", "A Sample API for Parties", "1.0.0", "Party Management",
						new Contact("Nikhila", "www.nikhilacorporation.com", "nikhiladamaraju30@gmail.com"), "Standard API License",
						"www.nikhila.com", Collections.emptyList()));

	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
