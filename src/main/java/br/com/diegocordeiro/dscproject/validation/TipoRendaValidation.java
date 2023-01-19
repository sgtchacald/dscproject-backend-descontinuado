package br.com.diegocordeiro.dscproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.TipoRenda;

public class TipoRendaValidation implements ConstraintValidator<TipoRenda, String> {
	
	public void initialize(TipoRenda constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.TipoRenda.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}