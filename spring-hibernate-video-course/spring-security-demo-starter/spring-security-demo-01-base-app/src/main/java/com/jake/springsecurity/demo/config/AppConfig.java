package com.jake.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.jake.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	// this holds the values from the properties file
	@Autowired
	private Environment env;
	
	// logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for the view resolover
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// define bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource securityDataSource= new ComboPooledDataSource();
				
		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection props for validation purposes
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(getIntProperty(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(getIntProperty(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(getIntProperty(env.getProperty("connection.pool.maxIdleTime")));
		
		return securityDataSource;
	}
	
	// create helper method to read environment property and convert from string to int
	private int getIntProperty(String property) {

		int propertyInt = Integer.parseInt(property);
		
		return propertyInt;
	}
	
}
