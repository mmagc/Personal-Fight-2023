package br.com.personalfight.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalfight.model.entity.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

}
