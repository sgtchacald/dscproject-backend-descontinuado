package br.com.diegocordeiro.dscproject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.diegocordeiro.dscproject.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{
	@Transactional(readOnly=true)
	Optional<Pais> findBySigla(String sigla);
}
