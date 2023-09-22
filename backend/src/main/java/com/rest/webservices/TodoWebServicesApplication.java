package com.rest.webservices;

import com.rest.webservices.model.Todo;
import com.rest.webservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class TodoWebServicesApplication implements ApplicationRunner {

	@Autowired
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoWebServicesApplication.class, args);
	}
	

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("*")
					.allowedOrigins("http://localhost:3000");
			}
		};
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Todo> todos = new ArrayList<>();

		todos.add(new Todo("Get AWS Certified",
				LocalDate.now().plusYears(10), false ));
		todos.add(new Todo("Learn DevOps",
				LocalDate.now().plusYears(11), false ));
		todos.add(new Todo("Learn Full Stack Development",
				LocalDate.now().plusYears(12), false ));

		todoRepository.saveAll(todos);


	}
}
