package br.com.personalfight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Exercicio;
import br.com.personalfight.model.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	private ExercicioRepository exercicioRepository;
	
	public ExercicioService(ExercicioRepository exercicioRepository) {
		super();
		this.exercicioRepository = exercicioRepository;
	}

	public List<Exercicio> findAll() {
		return exercicioRepository.findAll();
	}

}
