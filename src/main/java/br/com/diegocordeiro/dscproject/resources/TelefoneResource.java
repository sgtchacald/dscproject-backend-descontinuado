package br.com.diegocordeiro.dscproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.services.TelefoneService;

@RestController
@RequestMapping(value = "/telefone")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Telefone obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
