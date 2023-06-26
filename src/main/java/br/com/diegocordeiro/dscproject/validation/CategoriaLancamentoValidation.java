package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.domain.Banco;
import br.com.diegocordeiro.dscproject.domain.CategoriaLancamento;
import br.com.diegocordeiro.dscproject.dto.BancoDTO;
import br.com.diegocordeiro.dscproject.dto.CategoriaLancamentoDTO;
import br.com.diegocordeiro.dscproject.repositories.BancoRepository;
import br.com.diegocordeiro.dscproject.repositories.CategoriaLancamentoRepository;
import br.com.diegocordeiro.dscproject.resources.exception.FieldMessage;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarBanco;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarCategoriaLancamento;
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

public class CategoriaLancamentoValidation implements ConstraintValidator<ValidarCategoriaLancamento, CategoriaLancamentoDTO> {

	@Autowired
	private CategoriaLancamentoRepository categoriaLancamentoRepository;

	@Autowired
	private MessageSource messageSource;

	Integer id;
	public void initialize(ValidarCategoriaLancamento constraintAnnotation) {
	}

	public boolean isValid(CategoriaLancamentoDTO categoriaLancamentoDTO, ConstraintValidatorContext context) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String id = ServletUriComponentsBuilder.fromRequest(request).build().getPathSegments().get(1);

		if(NumberUtils.isCreatable(id)){
			categoriaLancamentoDTO.setId(Integer.parseInt(id));
		}

		List<FieldMessage> listaErros = new ArrayList<>();
		FieldMessage erro = new FieldMessage();

		boolean semErros = false;

		CategoriaLancamento categoriaLancamentoComMesmoNome = categoriaLancamentoRepository.findByNomeIgnoringCase(categoriaLancamentoDTO.getNome());

		erro = new FieldMessage("nome", "Já existe um registro com o nome '" + categoriaLancamentoDTO.getNome() + "'.");

		if(categoriaLancamentoDTO.getId() == null){
			if(!ObjectUtils.isEmpty(categoriaLancamentoComMesmoNome)){
				listaErros.add(erro);
			}
		}else{
			if(!ObjectUtils.isEmpty(categoriaLancamentoComMesmoNome) && categoriaLancamentoDTO.getId() != categoriaLancamentoComMesmoNome.getId()){
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