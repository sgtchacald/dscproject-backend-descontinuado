package br.com.diegocordeiro.dscproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.diegocordeiro.dscproject.validation.constraints.TipoPerfil;

public class TipoPerfilValidation implements ConstraintValidator<TipoPerfil, Integer> {
	
	public void initialize(TipoPerfil constraintAnnotation) {
    }

	@Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean retorno = true;
		try {
			if(value != null) {
				br.com.diegocordeiro.dscproject.enums.TipoPerfil.toEnum(value);
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		
		return retorno;
    }
}