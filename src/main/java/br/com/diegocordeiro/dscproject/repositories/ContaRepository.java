package br.com.diegocordeiro.dscproject.repositories;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.Conta;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

    Conta findByAgenciaAndAgenciaDigitoAndContaAndContaDigitoAndBanco
    (
        String agencia,
        String agenciaDigito,
        String conta,
        String contaDigito,
        Banco banco
    );

}
