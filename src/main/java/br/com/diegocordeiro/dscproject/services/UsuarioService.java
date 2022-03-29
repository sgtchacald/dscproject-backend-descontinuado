package br.com.diegocordeiro.dscproject.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.enums.OperacaoPersistencia;
import br.com.diegocordeiro.dscproject.repositories.TelefoneRepository;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.services.exceptions.DataIntegrityException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
	
	public Page<Usuario> buscarTodosComPaginacao(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pageRequest);
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		
		//Salvando o usuário
		usuarioRepository.save(obj);
		
		//Atribuindo os telefones caso existam, ao usuario que foi salvo.
		if(obj.getTelefones() != null) {
			for(Telefone t : obj.getTelefones()) {
				t.setUsuario(obj);
			}
		
			telefoneRepository.saveAll(obj.getTelefones());
		}
		
		emailService.enviaConfirmacaoHtmlCadastroUsuario(obj);
		
		return obj;
	}
	
	public Usuario update(Usuario obj) throws ObjectNotFoundException {
		Usuario newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return usuarioRepository.save(newObj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		buscarPorId(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir este usuário pois já existem entidades relacionadas a ele.");
		}
	}
	
	public Usuario fromDTO(UsuarioDTO objetoDTO, OperacaoPersistencia operacao){
		
		return new Usuario(
			operacao.equals(OperacaoPersistencia.INSERIR) ? null : objetoDTO.getId(), 
			objetoDTO.getNome(), 
			operacao.equals(OperacaoPersistencia.INSERIR) ? objetoDTO.getCpf() : null,
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
			passwordEncoder.encode(objetoDTO.getSenha()),
			objetoDTO.getTelefones()
		);
	}
	
	private void updateData(Usuario novoObjeto, Usuario objeto) {
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
		novoObjeto.setSenha(passwordEncoder.encode(objeto.getSenha()));
		novoObjeto.setTelefones(objeto.getTelefones());
	}
	
}
