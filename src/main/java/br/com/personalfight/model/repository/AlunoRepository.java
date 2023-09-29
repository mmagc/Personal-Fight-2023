package br.com.personalfight.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Instrutor;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findByEMAIL(String email);

	List<Aluno> findByInstrutor(Instrutor instrutor);

}
