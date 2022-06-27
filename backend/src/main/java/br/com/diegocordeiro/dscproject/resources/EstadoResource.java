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
	public ResponseEntity<List<EstadoDTO>> buscarPorPais(@RequestParam(value="pais") String sigla) {
		List<Estado> list = estadoService.buscarEstadosPorPais(sigla);
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estado obj = estadoService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{uf}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable String uf) {
		List<Cidade> list = cidadeService.buscarPorEstado(uf);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	

}
