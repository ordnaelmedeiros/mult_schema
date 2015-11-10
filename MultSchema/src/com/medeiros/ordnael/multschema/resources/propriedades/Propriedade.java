package com.medeiros.ordnael.multschema.resources.propriedades;

public class Propriedade {
	
	private String descricao;
	private String nome;
	private String valor;
	
	public Propriedade() {}
	
	public Propriedade(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Propriedade(String nome, String descricao, String valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
