package br.com.personalfight.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalfight.model.entity.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long>{

	Instrutor findByEMAIL(String email);

}
