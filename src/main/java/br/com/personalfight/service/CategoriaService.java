package br.com.personalfight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Categoria;
import br.com.personalfight.model.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

}
