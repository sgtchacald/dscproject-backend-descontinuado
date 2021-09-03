package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.DataIntegrityException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Page<Usuario> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
//	@Transactional
//	public Usuario insert(Usuario obj) {
//		obj.setId(null);
//		repositorio.save(obj);
//		return obj;
//	}
	
	public Usuario update(Usuario obj) throws ObjectNotFoundException {
		Usuario newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repositorio.save(newObj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		buscarPorId(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir este usuário pois já existem entidades relacionadas a ele.");
		}
	}
	
	public Usuario fromDTO(UsuarioDTO objetoDTO){
		return new Usuario(
			objetoDTO.getId(), 
			null, 
			objetoDTO.getNome(), 
			null, 
			objetoDTO.getDtNascimento(), 
			objetoDTO.getEstadoCivil(), 
			objetoDTO.getGenero(), 
			objetoDTO.getIndPortadorDeficiencia(), 
			objetoDTO.getIndDisponivelViajar(), 
			objetoDTO.getIndDisponivelMudarCidade(), 
			objetoDTO.getResumoProfissional(), 
			objetoDTO.getUrlBlogSite(), 
			objetoDTO.getIndStatus(), 
			objetoDTO.getEmail(), 
			objetoDTO.getLogin(), 
			objetoDTO.getSenha()
		);
	}
	
	private void updateData(Usuario novoObjeto, Usuario objeto) {
		//novoObjeto.setTipoPerfil(objeto.getTipoPerfil()); 
		novoObjeto.setNome(objeto.getNome());
		//novoObjeto.setCpf(objeto.getCpf()); 
		novoObjeto.setDtNascimento(objeto.getDtNascimento()); 
		novoObjeto.setEstadoCivil(objeto.getEstadoCivil());
		novoObjeto.setGenero(objeto.getGenero()); 
		novoObjeto.setIndPortadorDeficiencia(objeto.getIndPortadorDeficiencia()); 
		novoObjeto.setIndDisponivelViajar(objeto.getIndDisponivelViajar());  
		novoObjeto.setIndDisponivelMudarCidade(objeto.getIndDisponivelMudarCidade());  
		novoObjeto.setResumoProfissional(objeto.getResumoProfissional());  
		novoObjeto.setUrlBlogSite(objeto.getUrlBlogSite());  
		novoObjeto.setIndStatus(objeto.getIndStatus());
		novoObjeto.setEmail(objeto.getEmail());  
		novoObjeto.setLogin(objeto.getLogin());  
		novoObjeto.setSenha(objeto.getSenha()); 
	}

}
