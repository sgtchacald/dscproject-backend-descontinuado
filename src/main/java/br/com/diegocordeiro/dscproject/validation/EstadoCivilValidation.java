package br.com.diegocordeiro.dscproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.EstadoCivil;

public class EstadoCivilValidation implements ConstraintValidator<EstadoCivil, String> {
	
	public void initialize(EstadoCivil constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.EstadoCivil.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}