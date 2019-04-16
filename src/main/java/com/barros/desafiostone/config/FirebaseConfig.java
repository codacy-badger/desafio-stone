package com.barros.desafiostone.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.github.fabiomaffioletti.firebase.EnableFirebaseRepositories;

@Configuration
@ComponentScan("com.barros.desafiostone")
@EnableFirebaseRepositories
@PropertySource("classpath:application.properties")
public class FirebaseConfig {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}

}
