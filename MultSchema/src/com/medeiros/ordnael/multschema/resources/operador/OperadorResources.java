package com.medeiros.ordnael.multschema.resources.operador;

import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.utils.AResources;

public class OperadorResources extends AResources<Operador> {

	@Override
	public Class<Operador> newClass() {
		return Operador.class;
	}

}
