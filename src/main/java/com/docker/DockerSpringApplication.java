package com.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class DockerSpringApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(DockerSpringApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(DockerSpringApplication.class, args);
	}

}
