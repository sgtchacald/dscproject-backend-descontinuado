package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.dto.UsuarioSiteNovoDTO;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UsuarioValidation implements ConstraintValidator<Usuario, UsuarioSiteNovoDTO> {
	
	@Autowired
	private UsuarioRepository repo;
	

	public void initialize(Usuario constraintAnnotation) {
	}

	public boolean isValid(UsuarioSiteNovoDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		//validações personalizadas
		if(dto.getLogin().isBlank()){
			list.add(new FieldMessage("Login", "Este campo não pode ser vazio"));
		}
		
		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorLogin = repo.findUsuarioByLogin(dto.getLogin());
		
		if(resultBuscaPorLogin.size() > 0){
			list.add(new FieldMessage("Login", "Este nome de usuário já existe no sistema"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();

	}

	
}