package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.TipoOperadoraTelefone;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoOperadoraTelefone;

public class ValidarTipoOperadoraTelefoneValidation implements ConstraintValidator<ValidarTipoOperadoraTelefone, String> {   
	
	public void initialize(ValidarTipoOperadoraTelefone constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				TipoOperadoraTelefone.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}