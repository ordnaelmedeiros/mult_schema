package com.medeiros.ordnael.multschema.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.medeiros.ordnael.multschema.resources.propriedades.PropriedadeResourses;

public class JPAUtils {

	private static EntityManagerFactory entityManagerFactory = null;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("principal",PropriedadeResourses.getPropriedades());
		} catch (Exception e) {}
	}
	
	public static void refreshEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("principal",PropriedadeResourses.getPropriedades());
	}
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
}
