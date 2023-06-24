package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.dto.BancoDTO;
import br.com.diegocordeiro.dscproject.repositories.BancoRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarBanco;
import com.amazonaws.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class BancoValidation implements ConstraintValidator<ValidarBanco, BancoDTO> {

	@Autowired
	private BancoRepository bancoRepository;

	@Autowired
	private MessageSource messageSource;

	Integer id;
	public void initialize(ValidarBanco constraintAnnotation) {
	}

	public boolean isValid(BancoDTO bancoDTO, ConstraintValidatorContext context) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String id = ServletUriComponentsBuilder.fromRequest(request).build().getPathSegments().get(1);

		if(NumberUtils.isCreatable(id)){
			bancoDTO.setId(Integer.parseInt(id));
		}

		List<FieldMessage> listaErros = new ArrayList<>();
		FieldMessage erro = new FieldMessage();

		boolean semErros = false;

		Banco bancoComMesmoNome = bancoRepository.findByNumero(bancoDTO.getNumero());
		erro = new FieldMessage("numero", "Já existe um registro com o número '" + bancoDTO.getNumero() + "'.");

		if(bancoDTO.getId() == null){
			if(!ObjectUtils.isEmpty(bancoComMesmoNome)){
				listaErros.add(erro);
			}
		}else{
			if(!ObjectUtils.isEmpty(bancoComMesmoNome) && bancoDTO.getId() != bancoComMesmoNome.getId()){
				listaErros.add(erro);
			}
		}

		Banco bancoComMesmoNumero = bancoRepository.findByNomeIgnoringCase(bancoDTO.getNome());
		erro = new FieldMessage("nome", "Já existe um registro com o nome '" + bancoDTO.getNome() + "'.");
		if(bancoDTO.getId() == null){
			if(!ObjectUtils.isEmpty(bancoComMesmoNumero)){
				listaErros.add(erro);
			}
		}else{
			if(!ObjectUtils.isEmpty(bancoComMesmoNumero) && bancoDTO.getId() != bancoComMesmoNumero.getId()){
				listaErros.add(erro);
			}
		}

		if(listaErros.isEmpty()){
			semErros = true;
		}else{
			for (FieldMessage e : listaErros) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
			}
		}

		return semErros;
	}
}