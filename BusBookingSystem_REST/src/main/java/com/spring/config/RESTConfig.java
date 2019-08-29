package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class RESTConfig {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("myPersistanceUnit");
		return emfb;
	}
}