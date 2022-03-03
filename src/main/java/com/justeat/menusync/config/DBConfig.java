package com.justeat.menusync.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.justeat.menusync")
@PropertySource(value="classpath:application.properties")
public class DBConfig {

		@Autowired
	    Environment environment;
	 
	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("com.justeat.menusync.model");
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }
	 
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
	       // properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
	        return properties; 
	    }
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
	        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
	        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
	        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
	        return dataSource;
	    }
	     
	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	        HibernateTransactionManager txManager = new HibernateTransactionManager();
	        txManager.setSessionFactory(s);
	        return txManager;
	    }
}
*/