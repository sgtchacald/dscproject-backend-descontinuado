package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.PaisRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repositorio;
	
	public List<Pais> findAll() {
		return repositorio.findAll();
	}
	
	public Pais buscarPorId(Integer id) {
		Optional<Pais> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

	public Pais buscarPorSigla(String sigla) {
		Pais obj = repositorio.findBySigla(sigla);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Pais: " + obj + ", Tipo: " + Pais.class.getName());
		}
		return obj;
	}

}
