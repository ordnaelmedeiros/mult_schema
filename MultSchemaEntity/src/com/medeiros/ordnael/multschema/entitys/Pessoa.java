package com.medeiros.ordnael.multschema.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", initialValue = 1)
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PESSOA")
	private Long pessoaId;
	
	@Column(length=100)
	private String nome;
	
	private Date nascimento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="enderecoId")
	private Endereco endereco;
	
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
