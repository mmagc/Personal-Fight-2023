package br.com.personalfight.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EXERCICIO")
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String NOME_EXERCICIO;
	private String DESCRICAO;
	
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID")
	private Categoria categoria;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNOME_EXERCICIO() {
		return NOME_EXERCICIO;
	}

	public void setNOME_EXERCICIO(String nOME_EXERCICIO) {
		NOME_EXERCICIO = nOME_EXERCICIO;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	
}