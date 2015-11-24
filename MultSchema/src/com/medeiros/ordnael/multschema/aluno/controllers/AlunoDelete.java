package com.medeiros.ordnael.multschema.aluno.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.aluno.resources.AlunoResDeletar;
import com.medeiros.ordnael.multschema.entitys.Aluno;

@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoDelete {
	
	@DELETE
	@Path("{id}")
	public Aluno delete(@PathParam("id") Long id) {
		return new AlunoResDeletar().deletar(id);
	}

}
