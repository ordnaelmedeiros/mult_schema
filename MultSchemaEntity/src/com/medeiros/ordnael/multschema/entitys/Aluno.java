package com.medeiros.ordnael.multschema.entitys;

import javax.persistence.CascadeType;
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
@SequenceGenerator(name = "SEQ_ALUNO", sequenceName = "SEQ_ALUNO", initialValue = 1)
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ALUNO")
	private Long alunoId;
	
	@Column(length=50)
	private String nome;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
	@JoinColumn(name="enderecoId")
	private Endereco endereco;
	
	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
