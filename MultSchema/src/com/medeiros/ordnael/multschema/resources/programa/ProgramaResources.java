package com.medeiros.ordnael.multschema.resources.programa;

import com.medeiros.ordnael.multschema.entitys.Programa;
import com.medeiros.ordnael.multschema.utils.AResources;

public class ProgramaResources extends AResources<Programa> {

	@Override
	public Class<Programa> newClass() {
		return Programa.class;
	}

}
