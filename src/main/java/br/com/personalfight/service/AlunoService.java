package br.com.personalfight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Instrutor;
import br.com.personalfight.model.repository.AlunoRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {
	
	private AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		super();
		this.alunoRepository = alunoRepository;
	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}
	
	public List<Aluno> findByInstrutor(Instrutor instrutor) {
		return alunoRepository.findByInstrutor(instrutor);
	}
	
	
	@Transactional
	public Aluno saveNew(Aluno aluno) {
		
		aluno.setSENHA("12345678");
		return alunoRepository.save(aluno);
	}

	public Aluno findByEmail(String email) {
		// TODO Auto-generated method stub
		return alunoRepository.findByEMAIL(email);
	}

	public Aluno findById(long id) {
		// TODO Auto-generated method stub
		return alunoRepository.findById(id).get();
	}

}
