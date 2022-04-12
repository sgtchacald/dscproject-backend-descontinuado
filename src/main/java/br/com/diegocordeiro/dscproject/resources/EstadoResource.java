package br.com.diegocordeiro.dscproject.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Cidade;
import br.com.diegocordeiro.dscproject.domain.Estado;
import br.com.diegocordeiro.dscproject.dto.CidadeDTO;
import br.com.diegocordeiro.dscproject.dto.EstadoDTO;
import br.com.diegocordeiro.dscproject.services.CidadeService;
import br.com.diegocordeiro.dscproject.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estado obj = estadoService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/buscarPorPais", method=RequestMethod.GET)
	public ResponseEntity<Optional<List<Estado>>> buscarPorPais(@RequestParam(value="sigla") String sigla) {
		Optional<List<Estado>> obj = estadoService.buscarEstadosPorPais(sigla);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.buscarPorEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	

}
