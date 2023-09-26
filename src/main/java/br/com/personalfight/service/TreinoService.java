package br.com.personalfight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Treino;
import br.com.personalfight.model.repository.TreinoRepository;

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

}
