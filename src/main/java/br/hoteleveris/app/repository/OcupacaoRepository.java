package br.hoteleveris.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Ocupacao;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Long> {

	Optional<Ocupacao>findById(Long id);
	
}
