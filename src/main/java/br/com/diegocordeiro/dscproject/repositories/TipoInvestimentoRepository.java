package br.com.diegocordeiro.dscproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diegocordeiro.dscproject.domain.TipoInvestimento;

@Repository
public interface TipoInvestimentoRepository extends JpaRepository<TipoInvestimento, Integer>{
}
