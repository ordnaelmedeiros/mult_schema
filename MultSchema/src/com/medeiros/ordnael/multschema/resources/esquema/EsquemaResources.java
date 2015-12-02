package com.medeiros.ordnael.multschema.resources.esquema;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Esquema;

public class EsquemaResources extends AResources<Esquema> {

	@Override
	public Class<Esquema> newClass() {
		return Esquema.class;
	}
	
	@Override
	public Esquema post(Esquema ent) throws Exception {
		
		// criar esquema
		// criar operador
		
		//return super.post(ent);
		return null;
	}
	
	@Override
	public Esquema put(Esquema ent) throws Exception {
		throw new Exception("Não é possivel excluir");
	}
	
	@Override
	public Esquema delete(Long id) throws Exception {
		throw new Exception("Não é possivel excluir");
	}
}
