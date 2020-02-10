package edu.roadrunner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Filme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1289016732692022016L;


	@Id
	@Column(name="idfilme")
	private int    idFilme;
	
	@Column(name="Titulo")
	private String titulo;
	
	@Column(name="Sinopse")
	private String sinopse;
	
	@Column(name="Consumo")
	private int    consumo;
	
	@Column(name="Categoria_idcategoria")
	private int    categoria_idCategoria;
	
	@Column(name="Genero_idgenero")
	private int    genero_idGenero;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Categoria_idcategoria", insertable=false, updatable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Genero_idgenero", insertable=false, updatable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Genero genero;
	
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	public void setCategoria_idCategoria(int categoria_idCategoria) {
		this.categoria_idCategoria = categoria_idCategoria;
	}
	public void setGenero_idGenero(int genero_idGenero) {
		this.genero_idGenero = genero_idGenero;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public int getConsumo() {
		return consumo;
	}
	public int getCategoria_idCategoria() {
		return categoria_idCategoria;
	}
	public int getGenero_idGenero() {
		return genero_idGenero;
	}
	
    @Override
    public String toString() { 	
    	
        return "Filme {" +
                "idFilme=" + this.getIdFilme() +
                ", Titulo='" + this.getTitulo() + '\'' +
                ", Sinopse='" + this.getSinopse() + '\'' +
                ", Consumo='" + this.getConsumo() + '\'' +
                ", Categoria_idCategoria='" + this.getCategoria_idCategoria() + '\'' +
                ", Genero_idGenero='" + this.getGenero_idGenero() + '\'' +
                '}';
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
        
    public Genero getGenero() {
        return genero;
    }
    
	

}
