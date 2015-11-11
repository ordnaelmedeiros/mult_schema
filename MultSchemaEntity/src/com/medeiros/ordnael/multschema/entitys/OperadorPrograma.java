package com.medeiros.ordnael.multschema.entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="public")
public class OperadorPrograma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="operadorId")
	private Operador operador;
	
	@ManyToOne
	@JoinColumn(name="programaId")
	private Programa programa;
	
	private Boolean get;
	private Boolean post;
	private Boolean put;
	private Boolean delete;
	
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
