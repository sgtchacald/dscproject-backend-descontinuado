package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.Status;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarStatus;

public class ValidarStatusValidation implements ConstraintValidator<ValidarStatus, String> {   
	
	public void initialize(ValidarStatus constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				Status.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}