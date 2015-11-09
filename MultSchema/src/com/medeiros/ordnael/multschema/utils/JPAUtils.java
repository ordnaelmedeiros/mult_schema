package com.medeiros.ordnael.multschema.utils;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	//private static SessionFactory sessionFactory;
	
	static {
		
		Properties properties=new Properties();
		
		properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		properties.setProperty("hibernate.connection.username", "postgres");
		properties.setProperty("hibernate.connection.password", "ids0207");
		properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mult_schema");
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.default_schema", "public");
		
		entityManagerFactory = Persistence.createEntityManagerFactory("principal",properties);
	    
	}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
}
