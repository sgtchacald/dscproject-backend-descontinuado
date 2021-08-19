package br.com.diegocordeiro.dscproject.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.services.EstadoService;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estado obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
