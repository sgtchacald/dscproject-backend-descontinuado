package br.com.diegocordeiro.dscproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.TipoInvestimento;
import br.com.diegocordeiro.dscproject.repositories.TipoInvestimentoRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class TipoInvestimentoService {

	@Autowired
	private TipoInvestimentoRepository repositorio;
	
	public TipoInvestimento buscar(Integer id) {
		Optional<TipoInvestimento> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + TipoInvestimento.class.getName()));
	}

}
