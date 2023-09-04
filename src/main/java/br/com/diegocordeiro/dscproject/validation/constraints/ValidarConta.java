package br.com.diegocordeiro.dscproject.validation.constraints;

import br.com.diegocordeiro.dscproject.validation.BancoValidation;
import br.com.diegocordeiro.dscproject.validation.ContaValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContaValidation.class)
@Documented
public @interface ValidarConta {

    String message() default "Erro de validação.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
