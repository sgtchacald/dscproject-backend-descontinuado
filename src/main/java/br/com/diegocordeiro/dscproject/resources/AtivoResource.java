package br.com.diegocordeiro.dscproject.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.dto.AtivoDTO;
import br.com.diegocordeiro.dscproject.services.AtivoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/ativo")
public class AtivoResource {
	
	@Autowired
	private AtivoService service;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Ativo obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Ativo> insert(@RequestBody Ativo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ativo> update(@Valid @RequestBody AtivoDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Ativo obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
//	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
	
	
	

}
