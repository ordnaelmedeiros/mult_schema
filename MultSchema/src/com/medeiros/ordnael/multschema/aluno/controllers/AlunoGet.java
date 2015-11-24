package com.medeiros.ordnael.multschema.aluno.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.aluno.resources.AlunoResListar;
import com.medeiros.ordnael.multschema.entitys.Aluno;

@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoGet {

	@GET
	public List<Aluno> get(@QueryParam("join") List<String> join) {
		return new AlunoResListar().listar(join);
	}
	
	@GET
	@Path("{id}")
	public Aluno get(@PathParam("id") Long id) {
		return new AlunoResListar().listar(id);
	}
	
}
