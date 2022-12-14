package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.TipoRenda;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoRenda;

public class ValidarTipoRendaValidation implements ConstraintValidator<ValidarTipoRenda, String> {   
	
	public void initialize(ValidarTipoRenda constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				TipoRenda.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}