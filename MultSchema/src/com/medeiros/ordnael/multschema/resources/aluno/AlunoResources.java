package com.medeiros.ordnael.multschema.resources.aluno;

import java.util.List;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class AlunoResources {

	
	public List<Aluno> get() {
		EntityManager em = JPAUtils.createEntityManager();
		List<Aluno> list = em.createQuery("select alu from Aluno alu join fetch alu.endereco ", Aluno.class).getResultList();
		em.close();
		return list;
	}
	
	public Aluno get(Long id) {
		EntityManager em = JPAUtils.createEntityManager();
		Aluno alu = em.find(Aluno.class, id);
		em.close();
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
	
}
