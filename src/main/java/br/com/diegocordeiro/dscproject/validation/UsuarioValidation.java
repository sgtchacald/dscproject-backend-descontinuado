package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.dto.UsuarioDTO;
import br.com.diegocordeiro.dscproject.dto.UsuarioSiteNovoDTO;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
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

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorCPF = repo.findByCredenciaisList(dto.getCpf());

		if(resultBuscaPorCPF.size() > 0){
			list.add(new FieldMessage("CPF", "Este CPF já existe no sistema"));
		}

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorEmail = repo.findByCredenciaisList(dto.getEmail());

		if(resultBuscaPorEmail.size() > 0){
			list.add(new FieldMessage("E-mail", "Este E-mail já existe no sistema"));
		}

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorLogin = repo.findByCredenciaisList(dto.getLogin());

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