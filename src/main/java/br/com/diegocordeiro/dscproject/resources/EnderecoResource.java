package br.com.diegocordeiro.dscproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Endereco;
import br.com.diegocordeiro.dscproject.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Endereco obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
