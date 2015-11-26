package com.medeiros.ordnael.multschema.resources.aluno.resources;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class AlunoResGravar {

	public Aluno gravar(Aluno alu) {
		EntityManager em = JPAUtils.createEntityManager();
		em.getTransaction().begin();
		if (alu.getEndereco()!=null) {
			if (alu.getEndereco().getEnderecoId()==null) {
				em.persist(alu.getEndereco());
			} else {
				em.merge(alu.getEndereco());
			}
		}
		em.persist(alu);
		em.getTransaction().commit();
		em.close();
		return alu;
	}
	
}
