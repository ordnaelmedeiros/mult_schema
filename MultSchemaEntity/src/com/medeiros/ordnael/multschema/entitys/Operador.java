package com.medeiros.ordnael.multschema.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public")
@SequenceGenerator(name = "SEQ_OPERADOR", sequenceName = "SEQ_OPERADOR", initialValue = 1)
public class Operador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OPERADOR")
	private Long operadorId;
	
	@Column(length=15)
	private String nomeAcesso;
	
	@Column(length=32)
	private String senha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="esquemaId")
	private Esquema esquema;
	
	public Long getOperadorId() {
		return operadorId;
	}
	public void setOperadorId(Long operadorId) {
		this.operadorId = operadorId;
	}
	public String getNomeAcesso() {
		return nomeAcesso;
	}
	public void setNomeAcesso(String nomeAcesso) {
		this.nomeAcesso = nomeAcesso;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Esquema getEsquema() {
		return esquema;
	}
	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}
	
}
