package com.medeiros.ordnael.multschema.resources.operador;

import javax.ws.rs.Path;

import com.medeiros.ordnael.multschema.core.controller.AController;
import com.medeiros.ordnael.multschema.entitys.Operador;

@Path("operador")
public class OperadorController extends AController<Operador, OperadorResources>{

	public OperadorController() throws Exception {
		Operador opeAdmin = this.getRes().get(1l);
		if (opeAdmin==null) {
			opeAdmin = new Operador();
			opeAdmin.setNomeAcesso("admin");
			opeAdmin.setSenha("admin");
			this.getRes().post(opeAdmin);
		}
	}
	
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
	public OperadorResources newResource() {
		return new OperadorResources();
	}

}
