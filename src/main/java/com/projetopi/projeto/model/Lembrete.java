package com.projetopi.projeto.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Lembrete implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty
	private String anotacao1;
	
	private String anotacao2;
	
	private String anotacao3;
	
	private String anotacao4;
	
	private String anotacao5;
	
	private String observacao;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnotacao1() {
		return anotacao1;
	}

	public void setAnotacao1(String anotacao1) {
		this.anotacao1 = anotacao1;
	}

	public String getAnotacao2() {
		return anotacao2;
	}

	public void setAnotacao2(String anotacao2) {
		this.anotacao2 = anotacao2;
	}

	public String getAnotacao3() {
		return anotacao3;
	}

	public void setAnotacao3(String anotacao3) {
		this.anotacao3 = anotacao3;
	}

	public String getAnotacao4() {
		return anotacao4;
	}

	public void setAnotacao4(String anotacao4) {
		this.anotacao4 = anotacao4;
	}

	public String getAnotacao5() {
		return anotacao5;
	}

	public void setAnotacao5(String anotacao5) {
		this.anotacao5 = anotacao5;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
