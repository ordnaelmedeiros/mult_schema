package com.medeiros.ordnael.multschema.aluno.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.aluno.resources.AlunoResAtualizar;
import com.medeiros.ordnael.multschema.entitys.Aluno;

@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoPut {
	

	@PUT
	public Aluno put(Aluno alu) {
		return new AlunoResAtualizar().atualizar(alu);
	}

}
