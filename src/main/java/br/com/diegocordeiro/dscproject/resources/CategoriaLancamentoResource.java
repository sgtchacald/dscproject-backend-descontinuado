package br.com.diegocordeiro.dscproject.resources;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import br.com.diegocordeiro.dscproject.domain.Pais;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.*;
import br.com.diegocordeiro.dscproject.enums.OperacaoPersistencia;
import br.com.diegocordeiro.dscproject.services.CategoriaLancamentoService;
import br.com.diegocordeiro.dscproject.services.PaisService;
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
@RequestMapping(value = "/categorias-lancamento")
public class CategoriaLancamentoResource {
	
	@Autowired
	private CategoriaLancamentoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaLancamentoDTO>> buscarTodos(){
		List<CategoriaLancamento> list = service.buscarTodos();
		List <CategoriaLancamentoDTO> listDto = list.stream().map(obj -> new CategoriaLancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		CategoriaLancamento obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/inserir", method = RequestMethod.POST)
	public ResponseEntity<CategoriaLancamento> insert(@Valid @RequestBody CategoriaLancamentoDTO objDto){
		CategoriaLancamento obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CategoriaLancamento> update(@Valid @RequestBody CategoriaLancamentoDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException {
		CategoriaLancamento obj = service.fromDTO(objDto);
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
