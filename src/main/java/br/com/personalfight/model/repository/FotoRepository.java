package br.com.personalfight.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalfight.model.entity.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long>{

}
