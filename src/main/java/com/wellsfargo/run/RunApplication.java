package com.wellsfargo.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
///import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration//(exclude = { DataSourceAutoConfiguration.class,WebMvcAutoConfiguration.class })
@EnableJpaRepositories
@ComponentScan(basePackages = "com.wellsfargo.*")
public class RunApplication {
	public static void main(String[] args) {
		 SpringApplication.run(RunApplication.class, args);  
	}
}