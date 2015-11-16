package com.medeiros.ordnael.multschema.resources.aluno;

import java.util.List;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class AlunoResources {

	
	public List<Aluno> get() {
		EntityManager em = JPAUtils.createEntityManager();
		List<Aluno> list = em.createQuery("select alu from Aluno alu left join fetch alu.endereco ", Aluno.class).getResultList();
		em.close();
		return list;
	}
	
	public Aluno get(Long id) {
		
		Aluno alu = null;
		
		try {
			EntityManager em = JPAUtils.createEntityManager();
			alu = em.find(Aluno.class, id);
			alu.getEndereco();
			em.close();
		} catch (Exception e) {
			throw e;
		}
		
		return alu;
	}

	public Aluno post(Aluno alu) {
		EntityManager em = JPAUtils.createEntityManager();
		em.getTransaction().begin();
		em.persist(alu);
		em.getTransaction().commit();
		em.close();
		return alu;
	}

	public Aluno put(Aluno alu) {
		EntityManager em = JPAUtils.createEntityManager();
		em.getTransaction().begin();
		em.merge(alu);
		em.getTransaction().commit();
		em.close();
		return alu;
	}

	public Aluno delete(Long id) {
		EntityManager em = JPAUtils.createEntityManager();
		em.getTransaction().begin();
		Aluno alu = em.find(Aluno.class, id);
		em.remove(alu);
		em.getTransaction().commit();
		em.close();
		return alu;
	}
//	public static <T> T findEager(EntityManager em, Class<T> type, Object id) {
//	    T entity = em.find(type, id);
//	    for (Field field: type.getDeclaredFields()) {
//	        OneToMany annotation = field.getAnnotation(OneToMany.class);
//	        if (annotation != null) {
//	            if (annotation.fetch().equals(FetchType.LAZY)) {
//	                try {
//	                    new PropertyDescriptor(field.getName(), type).getReadMethod().invoke(entity);
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }
//	    }
//	    return entity;
//	}
}
