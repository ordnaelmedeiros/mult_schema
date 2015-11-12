package com.medeiros.ordnael.multschema.utils;

import java.util.List;

public class FormPesquisa<Entity> {

	private Integer pagina;
	private Integer quantidade;
	private Long total;
	private List<Entity> lista;
	
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer qauntidade) {
		this.quantidade = qauntidade;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<Entity> getLista() {
		return lista;
	}
	public void setLista(List<Entity> lista) {
		this.lista = lista;
	}
	
}
