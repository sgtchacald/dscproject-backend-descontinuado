package br.com.diegocordeiro.dscproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Investimento;
import br.com.diegocordeiro.dscproject.services.InvestimentoService;

@RestController
@RequestMapping(value = "/investimento")
public class InvestimentoResource {
	
	@Autowired
	private InvestimentoService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Investimento obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
