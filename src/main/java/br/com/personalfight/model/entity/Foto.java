package br.com.personalfight.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FOTO_ALUNO")
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String NOME_FOTO;
	private String DATA_FOTO;
	private byte[] FOTO;
	private String STATUS_FOTO;
	
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID")
	private Aluno aluno;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNOME_FOTO() {
		return NOME_FOTO;
	}

	public void setNOME_FOTO(String nOME_FOTO) {
		NOME_FOTO = nOME_FOTO;
	}

	public String getDATA_FOTO() {
		return DATA_FOTO;
	}

	public void setDATA_FOTO(String dATA_FOTO) {
		DATA_FOTO = dATA_FOTO;
	}

	

	public byte[] getFOTO() {
		return FOTO;
	}

	public void setFOTO(byte[] fOTO) {
		FOTO = fOTO;
	}

	public String getSTATUS_FOTO() {
		return STATUS_FOTO;
	}

	public void setSTATUS_FOTO(String sTATUS_FOTO) {
		STATUS_FOTO = sTATUS_FOTO;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	

	
	
	
	
}