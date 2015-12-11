package com.medeiros.ordnael.multschema.core.resourses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.utils.FormPesquisa;
import com.medeiros.ordnael.multschema.utils.JPAUtils;

public abstract class AResources<Entity> {
	
	public abstract Class<Entity> newClass();
	
	private Operador operador;
	
	private HttpServletRequest request;
    private ServletContext context;
	
	private EntityManager em;
	public EntityManager getEm() {
		if (this.em==null) {
			if (this.getOperador()==null || this.getOperador().getEsquema()==null) {
				this.em = JPAUtils.createEntityManager();
			} else {
				this.em = JPAUtils.createEntityManager(this.getOperador().getEsquema().getDescricao());
			}
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
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public Operador getOperador() {
		if (operador==null && this.getRequest()!=null && this.getRequest().getAttribute("operadorId")!=null) {
			operador = (Operador) this.getRequest().getAttribute("operadorId");
		}
		return operador;
	}
	
}
