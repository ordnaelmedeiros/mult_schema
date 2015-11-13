package com.medeiros.ordnael.multschema.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public")
@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", initialValue = 1)
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ENDERECO")
	private Long enderecoId;
	
	@Column(length=30)
	private String municipio;
	
	@Column(length=30)
	private String bairro;
	
	@Column(length=50)
	private String rua;
	
	@Column(length=10)
	private String numero;

	@OneToMany(fetch=FetchType.LAZY)
	private	List<Aluno> alunos;
	
	public Long getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
