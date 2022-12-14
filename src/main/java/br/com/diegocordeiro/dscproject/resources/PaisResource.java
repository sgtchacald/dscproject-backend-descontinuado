package br.com.diegocordeiro.dscproject.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.dto.PaisDTO;
import br.com.diegocordeiro.dscproject.services.PaisService;

@RestController
@RequestMapping(value = "/paises")
public class PaisResource {
	
	@Autowired
	private PaisService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PaisDTO>> findAll() {
		List<Pais> list = service.findAll();
		List<PaisDTO> listDto = list.stream().map(obj -> new PaisDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Pais obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/buscarPorSigla", method=RequestMethod.GET)
	public ResponseEntity<Pais> buscarPorSigla(@RequestParam(value="valor") String sigla) {
		Pais obj = service.buscarPorSigla(sigla);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
