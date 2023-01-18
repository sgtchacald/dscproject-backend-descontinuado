package br.com.diegocordeiro.dscproject.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.diegocordeiro.dscproject.dto.ExisteUsuarioDTO;
import br.com.diegocordeiro.dscproject.dto.UsuarioSiteNovoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.enums.OperacaoPersistencia;
import br.com.diegocordeiro.dscproject.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarTodos(){
		List<Usuario> list = service.buscarTodos();
		List <UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<UsuarioDTO>> buscarTodosComPaginacao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
			Page<Usuario> pagina = service.buscarTodosComPaginacao(page, linesPerPage, orderBy, direction);
			Page<UsuarioDTO> listDTO = pagina.map(obj-> new UsuarioDTO(obj)
		);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Usuario obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public ResponseEntity<Usuario> buscarPorEmail(@RequestParam(value="email") String email) {
		Usuario obj = service.buscarPorEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@Valid @RequestBody UsuarioDTO objDto){
		Usuario obj = service.fromDTO(objDto, OperacaoPersistencia.INSERIR);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/inserir-usuario-site", method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@Valid @RequestBody UsuarioSiteNovoDTO objDto){
		Usuario obj = service.fromDTOSite(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Usuario obj = service.fromDTO(objDto, OperacaoPersistencia.EDITAR);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/upload-imagem-perfil", method=RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/existe-usuario", method=RequestMethod.GET)
	public ResponseEntity<ExisteUsuarioDTO> buscarPorEmailOuLogin(@RequestParam(value="valor") String valor) {
		return ResponseEntity.ok().body(service.existeUsuario(valor));
	}

}
