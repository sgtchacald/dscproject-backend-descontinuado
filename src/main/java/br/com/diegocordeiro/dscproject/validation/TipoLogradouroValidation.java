package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.TipoLogradouro;

public class TipoLogradouroValidation implements ConstraintValidator<TipoLogradouro, Integer> {
	
	public void initialize(TipoLogradouro constraintAnnotation) {
    }

	@Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(value != null) {
				br.com.diegocordeiro.dscproject.enums.TipoLogradouro.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}