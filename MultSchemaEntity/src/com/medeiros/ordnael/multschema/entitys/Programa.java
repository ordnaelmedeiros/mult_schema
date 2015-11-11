package com.medeiros.ordnael.multschema.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public")
@SequenceGenerator(name = "SEQ_PROGRAMA", sequenceName = "SEQ_PROGRAMA", initialValue = 1)
public class Programa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROGRAMA")
	private Long programaId;
	
	@Column(length=100)
	private String descricao;
	
	@Column(length=50)
	private String rota;
	
	@Column(length=50)
	private String controller;

	public Long getProgramaId() {
		return programaId;
	}

	public void setProgramaId(Long programaId) {
		this.programaId = programaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}
	
}
