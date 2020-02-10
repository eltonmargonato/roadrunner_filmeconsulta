package edu.roadrunner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero implements Serializable {
	
	private static final long serialVersionUID = 7460386150977187122L;

	
	@Id
	@Column(name="idgenero")
	private int    idGenero;

	@Column(name="nome_genero")
	private String nomeGenero;
	
	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}
}
