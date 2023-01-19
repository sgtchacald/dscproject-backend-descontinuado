package br.com.diegocordeiro.dscproject.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import br.com.diegocordeiro.dscproject.validation.UsuarioValidation;



@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsuarioValidation.class)
@Documented
public @interface Usuario {

    String message() default "Erro de validação.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
