package com.medeiros.ordnael.multschema.core.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.utils.FormPesquisa;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AController<Entity, Resources extends AResources<Entity>> {
	
	abstract public Resources newResource() throws Exception;
	
	@Context
	private HttpServletRequest request;
    @Context
    private ServletContext context;
	
	private Resources res = null;
	public Resources getRes() throws Exception {
		if (this.res==null) {
			this.res = this.newResource();
			this.res.setRequest(request);
			this.res.setContext(context);
			
		}
		return res;
	}
	public void setRes(Resources res) {
		this.res = res;
	}
	
	@GET
	@Path("{id}")
	public Entity get(@PathParam("id") Long id) throws Exception {
		return this.getRes().get(id);
	}
	
	@POST
	public Entity post(Entity ent) throws Exception {
		return this.getRes().post(ent);
	}
	
	@PUT
	public Entity put(Entity ent) throws Exception {
		return this.getRes().put(ent);
	}
	
	@DELETE
	@Path("{id}")
	public Entity delete(@PathParam("id") Long id) throws Exception {
		return this.getRes().delete(id);
	}
	
	@GET
	@Path("pagina={pagina}/quantidade={quantidade}")
	public FormPesquisa<Entity> get(@PathParam("pagina") Integer pagina, @PathParam("quantidade") Integer quantidade) throws Exception {
		return this.getRes().get(pagina, quantidade);
	}
	
}
