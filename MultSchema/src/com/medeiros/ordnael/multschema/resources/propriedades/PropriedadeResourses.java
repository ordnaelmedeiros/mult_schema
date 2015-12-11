package com.medeiros.ordnael.multschema.resources.propriedades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class PropriedadeResourses {

	private static List<Propriedade> list;
	private static File file;
	private static Properties properties;

	static {
		
		list = new ArrayList<>();
		
		list.add(new Propriedade("hibernate.connection.driver_class", "Classe do Driver", "org.postgresql.Driver"));
		list.add(new Propriedade("hibernate.connection.username", "Usuário de Banco", "postgres"));
		list.add(new Propriedade("hibernate.connection.password", "Senha do Usuário de Banco", "ids0207"));
		list.add(new Propriedade("hibernate.connection.url", "URL de Conexão", "jdbc:postgresql://localhost:5432/mult_schema"));
		
		list.add(new Propriedade("hibernate.dialect", "Classe de Dialeto", "org.hibernate.dialect.PostgreSQLDialect"));
		list.add(new Propriedade("hibernate.hbm2ddl.auto", "Criação do Banco", "update"));
		list.add(new Propriedade("hibernate.show_sql", "Mostrar SQL no LOG", "true"));
		list.add(new Propriedade("hibernate.format_sql", "Formatar SQL no LOG", "true"));
		list.add(new Propriedade("hibernate.default_schema", "Schema do Banco", "public"));
		
		file = new File("MultSchema.properties");
		properties = new Properties();
		try {
			if (!file.exists()) {
				file.createNewFile();
				for (Propriedade p : list) {
					properties.setProperty(p.getNome(), p.getValor());
				}
				OutputStream out = new FileOutputStream(file);
				properties.store(out, null);
				
				out.close();
			} else {
				InputStream in = new FileInputStream(file);
				properties.load(in);
				in.close();
				
				for (Propriedade p : list) {
					p.setValor(properties.getProperty(p.getNome()));
				}
			}
			
		} catch (Exception e) {}
		
	}
	
	
	public static Properties getPropriedades() {
		return properties;
	}
	
	public static Properties getPropriedades(String schema) {
		Properties copia = new Properties();
		for (Enumeration propertyNames = properties.propertyNames();propertyNames.hasMoreElements();) {
			Object key = propertyNames.nextElement();
			copia.put(key, properties.get(key));
		}
		copia.setProperty("hibernate.default_schema", schema);
		return copia;
	}
	
	
	private void loadPropriedades() throws Exception {
		
		if (file.exists()) {
			
			InputStream in = new FileInputStream(file);
			properties.load(in);
			in.close();
			
			for (Propriedade p : list) {
				p.setValor(properties.getProperty(p.getNome()));
			}
			
		}
		
	}
	
	private void gravarPropriedades(List<Propriedade> lista) throws Exception {
		
		if (!file.exists()) {
			file.createNewFile();
		}
		this.loadPropriedades();
		for (Propriedade p : lista) {
			properties.setProperty(p.getNome(), p.getValor());
		}
		OutputStream out = new FileOutputStream(file);
		properties.store(out, null);
		
		out.close();
		
	}
	
	public List<Propriedade> get() throws Exception {
		this.loadPropriedades();
		return list;
	}
	
	public Boolean post(List<Propriedade> lista) throws Exception {
		this.gravarPropriedades(lista);
		JPAUtils.refreshEntityManagerFactory();
		return true;
	}
	
	public Boolean post(String nome, String valor) throws Exception {
		this.loadPropriedades();
		
		Propriedade prop = new Propriedade();
		prop.setNome(nome);
		prop.setValor(valor);
		
		List<Propriedade> lista = new ArrayList<>();
		lista.add(prop);
		
		this.gravarPropriedades(lista);
		
		JPAUtils.refreshEntityManagerFactory();
		
		return true;
		
	}
	
}
