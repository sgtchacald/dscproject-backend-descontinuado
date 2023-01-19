package br.com.diegocordeiro.dscproject.validation;

import br.com.diegocordeiro.dscproject.validation.constraints.Genero;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GeneroValidation implements ConstraintValidator<Genero, String> {
	
	public void initialize(Genero constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.Genero.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}