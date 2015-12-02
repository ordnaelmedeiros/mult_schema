package com.medeiros.ordnael.multschema.resources.privilegios;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Privilegio;
import com.medeiros.ordnael.multschema.entitys.Programa;

public class PrivilegioResources extends AResources<Privilegio> {

	@Override
	public Class<Privilegio> newClass() {
		return Privilegio.class;
	}
	
	public List<Privilegio> getByOperador(Long id) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Privilegio> list = this.createCriteria(Privilegio.class)
					.add(Restrictions.eq("operador.operadorId", id))
					.list();
			this.close();
			return list;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public Privilegio getByOperadorAndPrograma(Long id, String nomePrograma) throws Exception {
		try {
			
			Programa programa = (Programa)this.createCriteria(Programa.class)
					.add(Restrictions.eq("controller", nomePrograma))
					.uniqueResult();
			
			Privilegio privilegio = (Privilegio)this.createCriteria(Privilegio.class)
					.add(Restrictions.eq("operador.operadorId", id))
					.add(Restrictions.eq("programa", programa))
					.uniqueResult();
			
			this.close();
			return privilegio;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
