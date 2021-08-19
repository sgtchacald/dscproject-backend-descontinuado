package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Investimento;
import br.com.diegocordeiro.dscproject.repositories.InvestimentoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository repositorio;
	
	public Investimento buscar(Integer id) {
		Optional<Investimento> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Investimento.class.getName()));
	}

}
