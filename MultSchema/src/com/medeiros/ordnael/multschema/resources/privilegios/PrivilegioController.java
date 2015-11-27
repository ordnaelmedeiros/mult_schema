package com.medeiros.ordnael.multschema.resources.privilegios;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Privilegio;

@Path("privilegio")
public class PrivilegioController extends AController<Privilegio, PrivilegioResources> {

	@Override
	public PrivilegioResources newResource() {
		return new PrivilegioResources();
	}
	
	@GET
	@Path("operador/{id}")
	public List<Privilegio> getByOperador(@PathParam("id") Long id) throws Exception {
		return this.getRes().getByOperador(id);
	}
	
}
