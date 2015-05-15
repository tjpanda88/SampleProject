package com.project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath*:spring/*.xml")
@PropertySource("classpath:application-config.properties")
public class WebJspApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebJspApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebJspApplication.class, args);
	}

}