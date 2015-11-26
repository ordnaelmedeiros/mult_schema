package com.medeiros.ordnael.multschema.resources.aluno.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.entitys.Aluno;
import com.medeiros.ordnael.multschema.resources.aluno.resources.AlunoResGravar;

@Path("aluno")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoPost {


	@POST
	public Aluno post(Aluno alu) {
		return new AlunoResGravar().gravar(alu);
	}
	
	
}
