package com.nexsystech.interview.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nexsystech.interview.helper.repository")
@ComponentScan(basePackages = { "com.nexsystech.interview.helper.*" })
public class HelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelperApplication.class, args);
	}

}
