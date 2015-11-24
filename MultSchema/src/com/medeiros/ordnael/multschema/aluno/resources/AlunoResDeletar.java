package com.medeiros.ordnael.multschema.aluno.resources;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class AlunoResDeletar {

	public Aluno deletar(Long id) {
		EntityManager em = JPAUtils.createEntityManager();
		em.getTransaction().begin();
		Aluno alu = em.find(Aluno.class, id);
		em.remove(alu);
		em.getTransaction().commit();
		em.close();
		return alu;
	}
	
}
