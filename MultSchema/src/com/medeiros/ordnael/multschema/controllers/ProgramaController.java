package com.medeiros.ordnael.multschema.controllers;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.entitys.Programa;
import com.medeiros.ordnael.multschema.resources.programa.ProgramaResources;
import com.medeiros.ordnael.multschema.utils.AController;

@Path("programa")
public class ProgramaController extends AController<Programa, ProgramaResources> {

	@Override
	public ProgramaResources newResource() {
		return new ProgramaResources();
	}

}
