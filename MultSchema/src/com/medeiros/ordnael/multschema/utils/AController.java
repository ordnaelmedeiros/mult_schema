package com.medeiros.ordnael.multschema.utils;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AController<Entity, Resources extends AResources<Entity>> {

	private Resources res = null;
	public Resources getRes() {
		if (this.res==null) {
			this.res = this.newResource();
		}
		return res;
	}
	public void setRes(Resources res) {
		this.res = res;
	}

	abstract public Resources newResource();
	
	@GET
	@Path("{id}")
	public Entity get(@PathParam("id") Long id) throws Exception {
		return this.getRes().get(id);
	}
	
	@POST
	public Long post(Entity ent) throws Exception {
		return this.getRes().post(ent);
	}
	
	@PUT
	public Boolean put(Entity ent) throws Exception {
		return this.getRes().put(ent);
	}
	
	@DELETE
	@Path("{id}")
	public Boolean delete(@PathParam("id") Long id) throws Exception {
		return this.getRes().delete(id);
	}
	
}
