package br.com.diegocordeiro.dscproject.repositories;

import br.com.diegocordeiro.dscproject.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer>{
}
