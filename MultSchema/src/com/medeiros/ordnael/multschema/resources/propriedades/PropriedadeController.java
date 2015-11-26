package com.medeiros.ordnael.multschema.resources.propriedades;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("propriedade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PropriedadeController {

	private PropriedadeResourses res = new PropriedadeResourses();
	
	public PropriedadeResourses getRes() {
		return res;
	}
	public void setRes(PropriedadeResourses res) {
		this.res = res;
	}

	@GET
	public List<Propriedade> get() throws Exception {
		return this.getRes().get();
	}
	
	@POST
	public Boolean post(List<Propriedade> lista) throws Exception {
		return this.getRes().post(lista);
	}
	
}
