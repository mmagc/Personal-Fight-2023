package br.com.personalfight.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	private String NOME;
	private String SEXO;
	private LocalDate DATANASC;
	private double ALTURA;
	private String EMAIL;
	private String SENHA;
	private String TELEFONE;
	private String OBJETIVO;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getSEXO() {
		return SEXO;
	}

	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}

	public LocalDate getDATANASC() {
		return DATANASC;
	}

	public void setDATANASC(LocalDate dATANASC) {
		DATANASC = dATANASC;
	}

	public double getALTURA() {
		return ALTURA;
	}

	public void setALTURA(double aLTURA) {
		ALTURA = aLTURA;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	public String getSENHA() {
		return SENHA;
	}

	public void setSENHA(String sENHA) {
		SENHA = sENHA;
	}

	public String getTELEFONE() {
		return TELEFONE;
	}

	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public String getOBJETIVO() {
		return OBJETIVO;
	}

	public void setOBJETIVO(String oBJETIVO) {
		OBJETIVO = oBJETIVO;
	}
	
	

}
