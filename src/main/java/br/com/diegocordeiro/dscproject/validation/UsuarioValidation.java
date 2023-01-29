package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.dto.UsuarioSiteNovoDTO;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.UsuarioNovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Locale.ROOT;

public class UsuarioValidation implements ConstraintValidator<UsuarioNovo, UsuarioSiteNovoDTO> {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private MessageSource messageSource;
	

	public void initialize(UsuarioNovo constraintAnnotation) {
	}

	public boolean isValid(UsuarioSiteNovoDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		boolean semErros = false;

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorCPF = repo.findByCredenciaisList(dto.getCpf());

		if(resultBuscaPorCPF.size() > 0){
			list.add(new FieldMessage("cpf", messageSource.getMessage("validacao.campo.cpf.existe.no.sistema",null, ROOT)));
		}

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorEmail = repo.findByCredenciaisList(dto.getEmail());

		if(resultBuscaPorEmail.size() > 0){
			list.add(new FieldMessage("email", "Este E-mail já existe no sistema"));
		}

		List<br.com.diegocordeiro.dscproject.domain.Usuario> resultBuscaPorLogin = repo.findByCredenciaisList(dto.getLogin());

		if(resultBuscaPorLogin.size() > 0){
			list.add(new FieldMessage("login", "Este nome de usuário já existe no sistema"));
		}

		if(list.isEmpty()){
			semErros = true;
		}else{
			for (FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
			}
		}

		return semErros;

	}

	
}