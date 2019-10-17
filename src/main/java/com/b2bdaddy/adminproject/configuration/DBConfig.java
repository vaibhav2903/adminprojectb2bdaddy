package com.b2bdaddy.adminproject.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.dbb2bdaddy")
	public DataSource createProductCategoryServiceDataBase() {
		return DataSourceBuilder.create().build();
	}
	
	

}
