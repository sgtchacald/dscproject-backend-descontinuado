package br.com.diegocordeiro.dscproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diegocordeiro.dscproject.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer>{
}
