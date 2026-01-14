package com.huseyinsacikay.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.huseyinsacikay.configuration.GlobalProperties;

@SpringBootApplication
@EntityScan(basePackages = {"com.huseyinsacikay"})
@ComponentScan(basePackages = {"com.huseyinsacikay"})
@EnableJpaRepositories(basePackages = {"com.huseyinsacikay"})
//@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
