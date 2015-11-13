package com.medeiros.ordnael.multschema.utils;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public abstract class AResources<Entity> {
	
	public abstract Class<Entity> newClass();
	
	private EntityManager em;
	public EntityManager getEm() {
		if (this.em==null) {
			this.em = JPAUtils.createEntityManager();
		}
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public Criteria createCriteria(@SuppressWarnings("rawtypes") Class classe) {
		Session session = this.getEm().unwrap(org.hibernate.Session.class);
		return session.createCriteria(classe);
	}
	
	public void close() {
		this.getEm().close();
		this.setEm(null);
	}
	
	public Entity get(Long id) throws Exception {
		Entity ent = this.getEm().find(this.newClass(), id);
		this.close();
		return ent;
	}
	
	public Entity post(Entity ent) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			this.getEm().persist(ent);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
			throw e;
		} finally {
			this.close();
		}
		return ent;
	}
	
	public Entity put(Entity ent) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			this.getEm().merge(ent);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
			throw e;
		} finally {
			this.close();
		}
		return ent;
	}
	
	public Entity delete(Long id) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			Entity ent = this.getEm().find(this.newClass(), id);
			this.getEm().remove(ent);
			this.getEm().getTransaction().commit();
			return ent;
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
			throw e;
		} finally {
			this.close();
		}
	}

	public FormPesquisa<Entity> get(Integer pagina, Integer quantidade) throws Exception {
		
		FormPesquisa<Entity> form = new FormPesquisa<>();
		
		try {
			
			if (quantidade==null || quantidade<1) {
				quantidade = 20;
			}
			if (pagina==null || pagina<1) {
				pagina = 1;
			}

			form.setPagina(pagina);
			form.setQuantidade(quantidade);
			
			pagina--;
			
			@SuppressWarnings("unchecked")
			List<Entity> lista = this.createCriteria(this.newClass())
				.setFirstResult(pagina*quantidade)
				.setMaxResults(quantidade)
				.list();
			
			Long rowCount = (Long)this.createCriteria(this.newClass())
				.setProjection(Projections.rowCount())
				.uniqueResult();
			
			Long total = rowCount/quantidade;
			if ((rowCount%quantidade)!=0) {
				total++;
			}
			form.setTotal(total);
			
			form.setLista(lista);
			
		} catch (Exception e) {
			throw e;
		}
		return form;
	}
	
}
