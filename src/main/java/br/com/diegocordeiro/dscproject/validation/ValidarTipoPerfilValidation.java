package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoPerfil;

public class ValidarTipoPerfilValidation implements ConstraintValidator<ValidarTipoPerfil, Integer> {   
	
	public void initialize(ValidarTipoPerfil constraintAnnotation) {
    }

	@Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(value != null) {
				TipoPerfil.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}