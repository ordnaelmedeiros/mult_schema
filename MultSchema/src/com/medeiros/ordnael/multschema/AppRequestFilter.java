package com.medeiros.ordnael.multschema;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.multschema.entitys.Logado;
import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.resources.operador.OperadorResources;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

@Provider
public class AppRequestFilter implements ContainerRequestFilter  {

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
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//System.out.println("-> "+requestContext.getMethod());
		/*
		String authorization = requestContext.getHeaderString("Authorization");
		String token = requestContext.getHeaderString("Token");
		String path = requestContext.getUriInfo().getPath();
		
		try {
			
			int indexOf = path.indexOf("/oauth");
			
			if (indexOf==(-1)) {
				
				
				indexOf = path.indexOf("/propriedade");
				
				if (indexOf!=(-1)) {
					if (!authorization.equals("YWRtaW46OmFkbWlu")) {
						throw new IOException("Acesso Negado");
					}
				} else {
					
					if (authorization==null || token==null) {
						throw new IOException("Acesso Negado");
					}
					
					Logado logado = (Logado)this.createCriteria(Logado.class)
						.add(Restrictions.eq("token", token))
						.uniqueResult();
					
					if (logado==null) {
						throw new IOException("Acesso Negado");
					}
					
					Operador operador = new OperadorResources().getOperadorByBase64(authorization);
					if (operador==null) {
						throw new IOException("Acesso Negado");
					}
					
					if (!logado.getOperador().getOperadorId().equals(operador.getOperadorId())) {
						throw new IOException("Acesso Negado");
					}
					
					if (!operador.getOperadorId().equals(1l)) {
						
					}
					
				}
			}
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		*/
	}

}
