package com.medeiros.ordnael.multschema.utils;

import javax.persistence.EntityManager;

public abstract class AResources<Entity> {

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
	public void close() {
		this.getEm().close();
		this.setEm(null);
	}
	
	public Entity get(Long id) throws Exception {
		Entity ent = this.getEm().find(this.newClass(), id);
		this.close();
		return ent;
	}
	
	public Long post(Entity ent) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			this.getEm().persist(ent);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
		} finally {
			this.close();
		}
		return 1l;
	}
	
	public Boolean put(Entity ent) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			this.getEm().merge(ent);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
		} finally {
			this.close();
		}
		return true;
	}
	
	public Boolean delete(Long id) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			Entity ent = this.getEm().find(this.newClass(), id);
			this.getEm().remove(ent);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
		} finally {
			this.close();
		}
		return true;
	}
	
	public abstract Class<Entity> newClass();
	
}
