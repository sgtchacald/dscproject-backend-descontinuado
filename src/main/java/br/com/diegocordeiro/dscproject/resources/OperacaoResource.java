package br.com.diegocordeiro.dscproject.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegocordeiro.dscproject.domain.Operacao;
import br.com.diegocordeiro.dscproject.dto.OperacaoDTO;
import br.com.diegocordeiro.dscproject.services.OperacaoService;

@RestController
@RequestMapping(value = "/operacoes")
public class OperacaoResource {
	
	@Autowired
	private OperacaoService operacaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OperacaoDTO>> buscarTodos(){
		List<Operacao> list = operacaoService.buscarTodos();
		List <OperacaoDTO> listDto = list.stream().map(obj -> new OperacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Operacao obj = operacaoService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
