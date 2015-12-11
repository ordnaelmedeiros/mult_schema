package com.medeiros.ordnael.multschema.resources.pessoa;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Pessoa;

@Path("pessoa")
public class PessoaController extends AController<Pessoa, PessoaResources> {

	@Override
	public PessoaResources newResource() {
		return new PessoaResources();
	}

}
