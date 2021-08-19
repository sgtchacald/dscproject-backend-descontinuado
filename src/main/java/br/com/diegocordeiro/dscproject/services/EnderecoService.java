package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Endereco;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.EnderecoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositorio;
	
	public Endereco buscarPorId(Integer id) {
		Optional<Endereco> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

}
