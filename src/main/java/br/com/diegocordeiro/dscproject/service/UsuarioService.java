package br.com.diegocordeiro.dscproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElse(null);
	}

}
