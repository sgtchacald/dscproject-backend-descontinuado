package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.domain.Conta;
import br.com.diegocordeiro.dscproject.dto.ContaDTO;
import br.com.diegocordeiro.dscproject.repositories.ContaRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarConta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class ContaValidation implements ConstraintValidator<ValidarConta, ContaDTO> {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private MessageSource messageSource;

	Integer id;
	public void initialize(ValidarConta constraintAnnotation) {
	}

	public boolean isValid(ContaDTO contaDTO, ConstraintValidatorContext context) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String id = ServletUriComponentsBuilder.fromRequest(request).build().getPathSegments().get(1);

		if(NumberUtils.isCreatable(id)){
			contaDTO.setId(Integer.parseInt(id));
		}

		List<FieldMessage> listaErros = new ArrayList<>();
		FieldMessage erro = new FieldMessage();

		boolean semErros = false;

		Conta agenciaEContaIgualBanco = contaRepository
				.findByAgenciaAndAgenciaDigitoAndContaAndContaDigitoAndBanco(
					contaDTO.getAgencia(),
					contaDTO.getAgenciaDigito(),
					contaDTO.getConta(),
					contaDTO.getContaDigito(),
					contaDTO.getBanco()
		);

		erro = new FieldMessage("conta", "Já existe uma agencia e conta cadastrada no sistema para o banco '" + contaDTO.getBanco().getNome() + "'.");

		if(contaDTO.getId() == null){
			if(!ObjectUtils.isEmpty(agenciaEContaIgualBanco)){
				listaErros.add(erro);
			}
		}else{
			if(!ObjectUtils.isEmpty(agenciaEContaIgualBanco) && contaDTO.getId() != agenciaEContaIgualBanco.getId()){
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