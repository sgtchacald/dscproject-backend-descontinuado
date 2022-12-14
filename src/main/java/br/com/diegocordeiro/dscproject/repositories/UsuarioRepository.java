package br.com.diegocordeiro.dscproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.diegocordeiro.dscproject.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findUsuarioByLogin(String login);
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
