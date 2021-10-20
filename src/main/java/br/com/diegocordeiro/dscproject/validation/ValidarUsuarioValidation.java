package br.com.diegocordeiro.dscproject.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarUsuario;

public class ValidarUsuarioValidation implements ConstraintValidator<ValidarUsuario, UsuarioDTO> {
	
	@Autowired
	private UsuarioRepository repo;
	

	public void initialize(ValidarUsuario constraintAnnotation) {
	}

	public boolean isValid(UsuarioDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		//validações personalizadas
		if(dto.getLogin().isBlank()){
			list.add(new FieldMessage("Login", "Este campo não pode ser vazio"));
		}
		
		Usuario buscaPorLogin = repo.findByloginList(dto.getLogin());
		
		if(buscaPorLogin != null){
			list.add(new FieldMessage("Login", "Este nome de usuário já existe no sistema"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();

	}

	
}