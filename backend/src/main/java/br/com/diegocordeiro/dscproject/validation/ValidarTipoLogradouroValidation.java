package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.TipoLogradouro;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoLogradouro;

public class ValidarTipoLogradouroValidation implements ConstraintValidator<ValidarTipoLogradouro, Integer> {   
	
	public void initialize(ValidarTipoLogradouro constraintAnnotation) {
    }

	@Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(value != null) {
				TipoLogradouro.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}