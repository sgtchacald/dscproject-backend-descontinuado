package br.com.diegocordeiro.dscproject.validation.constraints;

import br.com.diegocordeiro.dscproject.validation.BancoValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BancoValidation.class)
@Documented
public @interface ValidarBanco {

    String message() default "Erro de validação.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
