package com.medeiros.ordnael.multschema.resources.oauth;

import javax.persistence.EntityManager;

import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public class OauthResources {

	public Operador get() {
		
		EntityManager em = JPAUtils.createEntityManager();
		
		Operador ope = em.find(Operador.class, 1l);
		
		if (ope==null) {
			ope = new Operador();
			ope.setOperadorId(1l);
			ope.setNomeAcesso("admin");
			ope.setSenha("admin");
		}
		em.close();
		
		return ope;
		
	}
	
}
