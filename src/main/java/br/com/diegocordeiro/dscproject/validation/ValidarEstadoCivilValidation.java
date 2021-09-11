package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.EstadoCivil;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarEstadoCivil;

public class ValidarEstadoCivilValidation implements ConstraintValidator<ValidarEstadoCivil, String> {   
	
	public void initialize(ValidarEstadoCivil constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				EstadoCivil.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}