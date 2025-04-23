package br.com.personalfight.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Treino;
import br.com.personalfight.model.repository.TreinoRepository;
import jakarta.transaction.Transactional;

@Service
public class TreinoService {
	
	private TreinoRepository treinoRepository;
	
	public TreinoService(TreinoRepository treinoRepository) {
		super();
		this.treinoRepository = treinoRepository;
	}

	public List<Treino> findAll() {
		return treinoRepository.findAll();
	}

	
	
	@Transactional
	public Treino saveNew(MultipartFile file, Treino treino, Aluno aluno) {

		if (file != null && file.getSize() > 0) {
			
				try {
					treino.setARQUIVO(file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		} else {
			treino.setARQUIVO(null);
		}

		treino.setAluno(aluno);
		
		return treinoRepository.save(treino);
	}

	public Treino findById(long id) {
		
		return treinoRepository.findById(id).get();
		
	}


}
