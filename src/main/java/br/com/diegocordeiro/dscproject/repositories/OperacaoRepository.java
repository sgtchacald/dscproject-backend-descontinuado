package br.com.diegocordeiro.dscproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diegocordeiro.dscproject.domain.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Integer>{
}
