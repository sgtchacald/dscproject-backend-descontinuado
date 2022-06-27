package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.Indicador;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarIndicador;

public class ValidarIndicadorValidation implements ConstraintValidator<ValidarIndicador, String> {   
	
	public void initialize(ValidarIndicador constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				Indicador.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}