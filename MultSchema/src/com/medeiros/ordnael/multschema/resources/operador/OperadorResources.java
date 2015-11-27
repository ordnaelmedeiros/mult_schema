package com.medeiros.ordnael.multschema.resources.operador;

import java.util.Base64;

import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Operador;

public class OperadorResources extends AResources<Operador> {

	public OperadorResources() throws Exception {
		Operador opeAdmin = this.get(1l);
		if (opeAdmin==null) {
			opeAdmin = new Operador();
			opeAdmin.setNomeAcesso("admin");
			opeAdmin.setSenha("admin");
			this.post(opeAdmin);
		}
	}
	
	@Override
	public Class<Operador> newClass() {
		return Operador.class;
	}
	
	@Override
	public Operador delete(Long id) throws Exception {
		return null;
	}
	
	public Operador getOperadorByBase64(String authorization) {

		try {

			byte[] valueDecoded = Base64.getDecoder().decode(authorization.getBytes());
			String loginSenha = new String(valueDecoded);
			
			String[] split = loginSenha.split("::");
			
			Operador ope = (Operador)this.createCriteria(Operador.class)
					.add(Restrictions.eq("nomeAcesso", split[0]))
					.add(Restrictions.eq("senha", split[1]))
					.uniqueResult();
			
			
			
			this.close();
			
			return ope;
		} catch (Exception e) {
			throw e;
		}

	}
	

}
