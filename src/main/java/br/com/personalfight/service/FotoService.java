package br.com.personalfight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Foto;
import br.com.personalfight.model.repository.FotoRepository;

@Service
public class FotoService {
	
	private FotoRepository fotoRepository;
	
	public FotoService(FotoRepository fotoRepository) {
		super();
		this.fotoRepository = fotoRepository;
	}

	public List<Foto> findAll() {
		return fotoRepository.findAll();
	}

}
