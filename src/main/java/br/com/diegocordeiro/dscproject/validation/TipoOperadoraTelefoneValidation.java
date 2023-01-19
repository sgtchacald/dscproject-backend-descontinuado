package br.com.diegocordeiro.dscproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.TipoOperadoraTelefone;

public class TipoOperadoraTelefoneValidation implements ConstraintValidator<TipoOperadoraTelefone, String> {
	
	public void initialize(TipoOperadoraTelefone constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.TipoOperadoraTelefone.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}