package com.medeiros.ordnael.multschema.resources.propriedades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class PropriedadeResourses {

	private static List<Propriedade> list;
	private static File file;
	private static Properties properties;
	
	public static Properties getPropriedades() {
		return properties;
	}
	
	static {
		
		list = new ArrayList<>();
		
		/*
		properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		properties.setProperty("hibernate.connection.username", "postgres");
		properties.setProperty("hibernate.connection.password", "ids0207");
		properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mult_schema");
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.default_schema", "public");
		
		
		list.add(new Propriedade("database_tipe", "Tipo deo Banco", "PostgresSQL"));
		
		list.add(new Propriedade("show_sql", "Mostrar SQL no log", "true"));
		list.add(new Propriedade("format_sql", "Mostrar SQL Formatado no log", "true"));
		
		list.add(new Propriedade("database", "Nome do Banco de Dados", "mult_schema"));
		list.add(new Propriedade("server", "IP/Caminho do Servidor do Banco", "localhost"));
		list.add(new Propriedade("porta", "Porta do Servidor do Banco", "5432"));
		list.add(new Propriedade("username", "Usuário do Banco", "postgres"));
		list.add(new Propriedade("password", "Senha do Usuário do Banco", "ids0207"));
		
		*/
		
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
			}
			
		} catch (Exception e) {}
		
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
