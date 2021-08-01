package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}
