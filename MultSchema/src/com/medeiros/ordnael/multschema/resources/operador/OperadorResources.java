package com.medeiros.ordnael.multschema.resources.operador;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Operador;

public class OperadorResources extends AResources<Operador> {

	@Override
	public Class<Operador> newClass() {
		return Operador.class;
	}
	
	@Override
	public Operador delete(Long id) throws Exception {
		return null;
	}

}
