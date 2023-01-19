package br.com.diegocordeiro.dscproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.Indicador;

public class IndicadorValidation implements ConstraintValidator<Indicador, String> {
	
	public void initialize(Indicador constraintAnnotation) {
    }

	@Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(!value.isBlank()) {
				br.com.diegocordeiro.dscproject.enums.Indicador.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}