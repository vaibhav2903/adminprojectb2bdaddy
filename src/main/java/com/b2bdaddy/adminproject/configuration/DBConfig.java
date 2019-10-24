package com.b2bdaddy.adminproject.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.b2bdaddy.adminproject.repository")
@EntityScan(basePackages = {"com.b2bdaddy.adminproject.entities"})
@EnableTransactionManagement
public class DBConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.dbb2bdaddy")
	public DataSource createProductCategoryServiceDataBase() {
		return DataSourceBuilder.create().build();
	}

}
