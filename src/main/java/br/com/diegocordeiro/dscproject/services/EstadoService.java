package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.EstadoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repositorio;
	
	public Estado buscarPorId(Integer id) {
		Optional<Estado> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

}
