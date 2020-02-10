package edu.roadrunner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {
		
	private static final long serialVersionUID = -515296853751455434L;
	
	@Id
	@Column(name="idcategoria")
	private int    idCategoria;
	
	@Column(name="nome_categoria")
	private String nomeCategoria;
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}
