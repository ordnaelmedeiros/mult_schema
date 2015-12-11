package com.medeiros.ordnael.multschema.resources.esquema;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Esquema;
import com.medeiros.ordnael.multschema.resources.propriedades.PropriedadeResourses;

public class EsquemaResources extends AResources<Esquema> {

	@Override
	public Class<Esquema> newClass() {
		return Esquema.class;
	}
	
	@Override
	public Esquema post(Esquema esquema) throws Exception {
		
		this.getEm().getTransaction().begin();
		try {
			
			this.getEm().persist(esquema);
			this.getEm().createNativeQuery("CREATE SCHEMA "+esquema.getDescricao()).executeUpdate();
			this.getEm().createNativeQuery("CREATE USER "+esquema.getDescricao()+" WITH PASSWORD '"+esquema.getDescricao()+"'").executeUpdate();
			this.getEm().getTransaction().commit();
			
			EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("principal",PropriedadeResourses.getPropriedades(esquema.getDescricao()));
			EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
			createEntityManager.close();
			
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
		} finally {
			this.getEm().close();
		}
		
		// criar esquema
		// criar operador
		/*
		REVOKE ALL ON DATABASE mult_schema FROM teste1;
		REVOKE ALL ON public.operador FROM teste1;
		REVOKE ALL ON public.aluno FROM teste1;
		REVOKE ALL ON SCHEMA public FROM teste1;
		DROP USER teste1;


		CREATE USER teste1 WITH PASSWORD 'teste1';
		GRANT ALL PRIVILEGES ON DATABASE mult_schema to teste1;
		
		
		*/
		
		//return super.post(ent);
		return esquema;
	}
	
	@Override
	public Esquema put(Esquema ent) throws Exception {
		throw new Exception("Não é possivel excluir");
	}
	
	@Override
	public Esquema delete(Long id) throws Exception {
		throw new Exception("Não é possivel excluir");
	}
}
