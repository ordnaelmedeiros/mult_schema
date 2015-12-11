package com.medeiros.ordnael.multschema.entitys;

import java.sql.Timestamp;

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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(schema="public")
@SequenceGenerator(name = "SEQ_LOGADO", sequenceName = "public.SEQ_LOGADO", schema="public", initialValue = 1)
public class Logado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LOGADO")
	private Long logadoId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operadorId", nullable=false)
	private Operador operador;
	
	@Column(nullable=false)
	private String token;
	
	@Column(nullable=false)
	private String autorizacao;
	
	@JsonIgnore
	@Column(nullable=false)
	private Timestamp inicioSessao;
	
	public Long getLogadoId() {
		return logadoId;
	}
	public void setLogadoId(Long logadoId) {
		this.logadoId = logadoId;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String authorization) {
		this.autorizacao = authorization;
	}
	public Timestamp getInicioSessao() {
		return inicioSessao;
	}
	public void setInicioSessao(Timestamp inicioSessao) {
		this.inicioSessao = inicioSessao;
	}
	
}
