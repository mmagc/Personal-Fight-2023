package br.com.personalfight.service;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.personalfight.model.entity.Instrutor;
import br.com.personalfight.model.repository.InstrutorRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class InstrutorService {
	
	private InstrutorRepository instrutorRepository;
	
	public InstrutorService(InstrutorRepository instrutorRepository) {
		super();
		this.instrutorRepository = instrutorRepository;
	}

	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}

	@Transactional
	public Instrutor saveNew(Instrutor instrutor) {
		
		instrutor.setSENHA("admin123");
		return instrutorRepository.save(instrutor);
	}

	public Instrutor findByEmail(String email) {
		// TODO Auto-generated method stub
		return instrutorRepository.findByEMAIL(email);
	}
	
	@Transactional
	public Instrutor acessar(String email, String senha) {
		
		Instrutor instrutor = instrutorRepository.findByEMAIL(email);
		
		if (instrutor != null ) {
			
			if (instrutor.getSENHA().equals(senha)) {
				
				return instrutor;
			
			}
		} 
		return null;	
	}
}

