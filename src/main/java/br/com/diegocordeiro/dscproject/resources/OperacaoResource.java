package br.com.diegocordeiro.dscproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Operacao;
import br.com.diegocordeiro.dscproject.services.OperacaoService;

@RestController
@RequestMapping(value = "/operacao")
public class OperacaoResource {
	
	@Autowired
	private OperacaoService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Operacao obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
