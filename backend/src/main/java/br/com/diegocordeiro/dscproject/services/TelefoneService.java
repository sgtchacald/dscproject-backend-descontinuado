package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.repositories.TelefoneRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository repositorio;
	
	public Telefone buscarPorId(Integer id) {
		Optional<Telefone> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Telefone.class.getName()));
	}

}
