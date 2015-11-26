package com.medeiros.ordnael.multschema.resources.programa;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Programa;

@Path("programa")
public class ProgramaController extends AController<Programa, ProgramaResources> {

	@Override
	public ProgramaResources newResource() {
		return new ProgramaResources();
	}

}
