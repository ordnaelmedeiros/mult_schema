package com.medeiros.ordnael.multschema.resources.aluno.resources;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class AlunoResListar {


	private Session session;
	
	public Session getSession() {
		if (session==null) {
			session = JPAUtils.createEntityManager().unwrap(org.hibernate.Session.class);
		}
		return session;
	}
	
	public List<Aluno> listar(List<String> join) {
		Criteria setFetchMode = this.getSession().createCriteria(Aluno.class);
		for (String tabela : join) {
			setFetchMode.setFetchMode(tabela, FetchMode.JOIN);
		}
		setFetchMode.add(Restrictions.idEq(2l));
		@SuppressWarnings("unchecked")
		List<Aluno> list = (List<Aluno>)setFetchMode.list();
		this.getSession().close();
		return list;
	}
	
	public Aluno listar(Long id) {
		
		try {
			Aluno alu = (Aluno)this.getSession().createCriteria(Aluno.class)
					.setFetchMode("endereco", FetchMode.JOIN)
					.add(Restrictions.idEq(id))
					.uniqueResult();
			
			this.getSession().close();
			return alu;
		} catch (Exception e) {
			this.getSession().close();
			throw e;
		}
		
	}

}
