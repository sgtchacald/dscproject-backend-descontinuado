package br.com.diegocordeiro.dscproject.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.dto.AtivoDTO;
import br.com.diegocordeiro.dscproject.services.AtivoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/ativos")
public class AtivoResource {
	
	@Autowired
	private AtivoService service;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Ativo obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtivoDTO>> buscarTodos(){
		List<Ativo> list = service.buscarTodos();
		List <AtivoDTO> listDto = list.stream().map(obj -> new AtivoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<AtivoDTO>> buscarTodosComPaginacao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
			Page<Ativo> pagina = service.buscarTodosComPaginacao(page, linesPerPage, orderBy, direction);
			Page<AtivoDTO> listDTO = pagina.map(obj-> new AtivoDTO(obj)
		);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Ativo> insert(@RequestBody Ativo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ativo> update(@Valid @RequestBody AtivoDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Ativo obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
