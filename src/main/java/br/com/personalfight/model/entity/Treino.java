package br.com.personalfight.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TREINO")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String NOME_TREINO;
	private String DESCRICAO;
	private byte[] ARQUIVO;
	
	

	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="INSTRUTOR_ID")
	private Instrutor instrutor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNOME_TREINO() {
		return NOME_TREINO;
	}

	public void setNOME_TREINO(String nOME_TREINO) {
		NOME_TREINO = nOME_TREINO;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}
	
	public byte[] getARQUIVO() {
		return ARQUIVO;
	}

	public void setARQUIVO(byte[] aRQUIVO) {
		ARQUIVO = aRQUIVO;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	
	
}