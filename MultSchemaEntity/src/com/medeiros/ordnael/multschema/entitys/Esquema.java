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
@SequenceGenerator(name = "SEQ_ESQUEMA", sequenceName = "public.SEQ_ESQUEMA", schema="public", initialValue = 1)
public class Esquema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESQUEMA")
	private Long esquemaId;
	
	@Column(length=15)
	private String descricao;

	public Long getEsquemaId() {
		return esquemaId;
	}
	public void setEsquemaId(Long esquemaId) {
		this.esquemaId = esquemaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}