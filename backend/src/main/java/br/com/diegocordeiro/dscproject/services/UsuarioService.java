package br.com.diegocordeiro.dscproject.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.enums.OperacaoPersistencia;
import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.repositories.TelefoneRepository;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.security.UserSS;
import br.com.diegocordeiro.dscproject.services.exceptions.AuthorizationException;
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
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${usuario.img.perfil.prefix}")
	private String prefix;
	
	@Value("${usuario.img.perfil.size}")
	private Integer size;
	
	public Usuario buscarPorId(Integer id) {
		UserSS user = authenticated();
		
		if(user == null || !user.hasRole(TipoPerfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		
		Optional<Usuario> obj = usuarioRepository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario buscarPorEmail(String email) {
		UserSS user = authenticated();
		if (user == null || !user.hasRole(TipoPerfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Usuario obj = usuarioRepository.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		
		return obj;
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
			operacao.equals(OperacaoPersistencia.INSERIR) ? null : objetoDTO.getUrlImagemPerfil(),
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
	
	/* Busca o usuario logado do spring security*/
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	/* Faz upload da imagem de perfil do usuario */
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		UserSS userSS = authenticated();
		if (userSS == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + "_" + userSS.getId() + ".jpg";
		URI uri = s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		
		Usuario usuario = usuarioRepository.getById(userSS.getId());
		usuario.setUrlImagemPerfil(uri.toString());
		usuarioRepository.saveAndFlush(usuario);
		
		return uri;
	}
	
}
