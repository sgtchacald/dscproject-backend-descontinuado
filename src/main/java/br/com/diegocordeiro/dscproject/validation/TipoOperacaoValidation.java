package br.com.diegocordeiro.dscproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.TipoOperacao;

public class TipoOperacaoValidation implements ConstraintValidator<TipoOperacao, String> {
	
	public void initialize(TipoOperacao constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.TipoOperacao.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}