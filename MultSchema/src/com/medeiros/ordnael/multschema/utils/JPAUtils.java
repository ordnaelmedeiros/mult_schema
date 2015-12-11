package com.medeiros.ordnael.multschema.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.medeiros.ordnael.multschema.resources.propriedades.PropriedadeResourses;

public class JPAUtils {

	private static EntityManagerFactory entityManagerFactory = null;
	private static HashMap<String, EntityManagerFactory> listEntityManagerFactory = new HashMap<String, EntityManagerFactory>();
	
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
	
	public static EntityManager createEntityManager(String esquema) {
		if (listEntityManagerFactory.get(esquema)!=null) {
			return listEntityManagerFactory.get(esquema).createEntityManager();
		} else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("principal",PropriedadeResourses.getPropriedades(esquema));
			listEntityManagerFactory.put(esquema, emf);
			return emf.createEntityManager();
		}
	}
	
}
