package com.medeiros.ordnael.multschema.resources.esquema;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Esquema;

@Path("privilegio")
public class EsquemaController extends AController<Esquema, EsquemaResources> {

	@Override
	public EsquemaResources newResource() {
		return new EsquemaResources();
	}
	
}
