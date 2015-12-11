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
import com.medeiros.ordnael.multschema.entitys.Privilegio;
import com.medeiros.ordnael.multschema.resources.operador.OperadorResources;
import com.medeiros.ordnael.multschema.resources.privilegios.PrivilegioResources;
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
		String authorization = requestContext.getHeaderString("Authorization");
		String token = requestContext.getHeaderString("Token");
		String path = requestContext.getUriInfo().getPath();
		String nomePrograma = "";
		if (path.indexOf("/", 1)>-1) {
			nomePrograma = path.substring(1, path.indexOf("/", 1));
		} else {
			nomePrograma = path.substring(1, path.length());
		}
		
		String metodo = requestContext.getMethod();
		
		try {
			
			int indexOf = path.indexOf("/oauth");
			
			if (indexOf==(-1)) {
				
				
				indexOf = path.indexOf("/propriedade");
				
				if (indexOf!=(-1)) {
					if (!authorization.equals("YWRtaW46OmFkbWlu")) {
						throw new IOException("Acesso Negado");
					}
					requestContext.getHeaders().add("operadorId", "1");
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
						
						Privilegio privilegio = new PrivilegioResources().getByOperadorAndPrograma(operador.getOperadorId(), nomePrograma);
						if (privilegio==null) {
							throw new IOException("Acesso Negado");
						} else {
							if (metodo.toUpperCase().equals("GET")) {
								if (!privilegio.getGet()) {
									throw new IOException("Acesso Negado");
								}
							} else if (metodo.toUpperCase().equals("POST")) {
								if (!privilegio.getPost()) {
									throw new IOException("Acesso Negado");
								}
							} else if (metodo.toUpperCase().equals("PUT")) {
								if (!privilegio.getPut()) {
									throw new IOException("Acesso Negado");
								}
							} else if (metodo.toUpperCase().equals("DELETE")) {
								if (!privilegio.getDelete()) {
									throw new IOException("Acesso Negado");
								}
							}
						}
						//System.out.println("--------> Validar");
						
					}
					requestContext.setProperty("operadorId", operador);
				}
				
				
				
			}
			
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		
	}

}
