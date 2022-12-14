package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Operacao;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.repositories.OperacaoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class OperacaoService {

	@Autowired
	private OperacaoRepository operacaoRepositorio;
	
	public List<Operacao> buscarTodos() {
		return operacaoRepositorio.findAll();
	}
	
	public Operacao buscarPorId(Integer id) {
		Optional<Operacao> obj = operacaoRepositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}
	
	

}
