package com.medeiros.ordnael.multschema.entitys;

import java.io.Serializable;

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
@SequenceGenerator(name = "SEQ_PRIVILEGIO", sequenceName = "SEQ_PRIVILEGIO", initialValue = 1)
public class Privilegio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PRIVILEGIO")
	private Long privilegioId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operadorId")
	private Operador operador;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="programaId")
	private Programa programa;
	
	private Boolean get;
	private Boolean post;
	private Boolean put;
	private Boolean delete;
	
	public Long getPrivilegioId() {
		return privilegioId;
	}
	public void setPrivilegioId(Long operadorProgramaId) {
		this.privilegioId = operadorProgramaId;
	}
	public Operador getOperador() {
		return operador;
	}
	public void setOperador(Operador operador) {
		this.operador = operador;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Boolean getGet() {
		return get;
	}
	public void setGet(Boolean get) {
		this.get = get;
	}
	public Boolean getPost() {
		return post;
	}
	public void setPost(Boolean post) {
		this.post = post;
	}
	public Boolean getPut() {
		return put;
	}
	public void setPut(Boolean put) {
		this.put = put;
	}
	public Boolean getDelete() {
		return delete;
	}
	public void setDelete(Boolean delete) {
		this.delete = delete;
	}
	
}
