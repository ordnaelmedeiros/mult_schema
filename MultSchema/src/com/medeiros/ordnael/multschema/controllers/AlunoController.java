package com.medeiros.ordnael.multschema.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.resources.aluno.AlunoResources;

@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoController {
	
	@GET
	public List<Aluno> get() {
		return new AlunoResources().get();
	}
	
	@GET
	@Path("{id}")
	public Aluno get(@PathParam("id") Long id) {
		return new AlunoResources().get(id);
	}
	
	@POST
	public Aluno post(Aluno alu) {
		return new AlunoResources().post(alu);
	}
	
	@PUT
	public Aluno put(Aluno alu) {
		return new AlunoResources().put(alu);
	}
	
	@DELETE
	@Path("{id}")
	public Aluno delete(@PathParam("id") Long id) {
		return new AlunoResources().delete(id);
	}
	
}
