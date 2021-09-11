package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.Genero;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarGenero;

public class ValidarGeneroValidation implements ConstraintValidator<ValidarGenero, String> {   
	
	public void initialize(ValidarGenero constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				Genero.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}