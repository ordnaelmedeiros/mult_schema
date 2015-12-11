package com.medeiros.ordnael.multschema.resources.pessoa;

import com.medeiros.ordnael.multschema.core.resourses.AResources;
import com.medeiros.ordnael.multschema.entitys.Endereco;
import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.entitys.Pessoa;

public class PessoaResources extends AResources<Pessoa> {

	@Override
	public Class<Pessoa> newClass() {
		return Pessoa.class;
	}

	private void atualizarEndereco(Endereco endereco) {
		if (endereco!=null) {
			if (endereco.getEnderecoId()==null) {
				this.getEm().persist(endereco);
			} else {
				this.getEm().merge(endereco);
			}
		}
	}
	
	@Override
	public Pessoa post(Pessoa pessoa) throws Exception {
		try {
			this.getEm().getTransaction().begin();
			this.atualizarEndereco(pessoa.getEndereco());
			this.getEm().persist(pessoa);
			this.getEm().getTransaction().commit();
		} catch (Exception e) {
			this.getEm().getTransaction().rollback();
			throw e;
		} finally {
			this.close();
		}
		return pessoa;
	}
	
	@Override
	public Pessoa get(Long id) throws Exception {
		Operador operador = (Operador) this.getRequest().getAttribute("operadorId");
		System.out.println("operadorId: "+operador.getNomeAcesso());
		return super.get(id);
	}
}
