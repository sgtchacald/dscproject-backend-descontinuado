package br.com.diegocordeiro.dscproject.resources;

import br.com.diegocordeiro.dscproject.domain.Conta;
import br.com.diegocordeiro.dscproject.dto.ContaDTO;
import br.com.diegocordeiro.dscproject.services.ContaService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContaDTO>> buscarTodos(){
		List<Conta> list = service.buscarTodos();
		List <ContaDTO> listDto = list.stream().map(obj -> new ContaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Conta obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/inserir", method = RequestMethod.POST)
	public ResponseEntity<Conta> insert(@Valid @RequestBody ContaDTO objDto){
		Conta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Conta> update(@Valid @RequestBody ContaDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException {
		Conta obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
