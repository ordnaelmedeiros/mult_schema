package com.medeiros.ordnael.multschema.resources.programa;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Programa;

public class ProgramaResources extends AResources<Programa> {

	@Override
	public Class<Programa> newClass() {
		return Programa.class;
	}

}
