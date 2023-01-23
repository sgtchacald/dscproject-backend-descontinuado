package br.com.diegocordeiro.dscproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.diegocordeiro.dscproject.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("SELECT u FROM Usuario u WHERE u.cpf = ?1 OR u.login = ?1 OR u.email = ?1")
	List<Usuario> findByCredenciaisList(String valor);

	@Query("SELECT u FROM Usuario u WHERE u.cpf = ?1 OR u.login = ?1 OR u.email = ?1")
	Usuario findByCredenciais(String valor);

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
