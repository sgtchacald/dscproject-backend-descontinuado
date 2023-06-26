package br.com.diegocordeiro.dscproject.repositories;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaLancamentoRepository extends JpaRepository<CategoriaLancamento, Integer>{
    CategoriaLancamento findByNomeIgnoringCase(String nome);

};
