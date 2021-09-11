package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.TipoOperacao;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoOperacao;

public class ValidarTipoOperacaoValidation implements ConstraintValidator<ValidarTipoOperacao, String> {   
	
	public void initialize(ValidarTipoOperacao constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				TipoOperacao.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}