package com.medeiros.ordnael.multschema.resources.operador;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Operador;

@Path("operador")
public class OperadorController extends AController<Operador, OperadorResources>{

	@Override
	public Operador get(Long id) throws Exception {
		/*
		for (int i=0; i<1000; i++) {
			super.get(id);
		}
		*/
		return super.get(id);
	}
	
	@Override
	public OperadorResources newResource() throws Exception {
		return new OperadorResources();
	}

}
