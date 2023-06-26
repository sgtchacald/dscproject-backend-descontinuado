package br.com.diegocordeiro.dscproject.validation.constraints;

import br.com.diegocordeiro.dscproject.validation.BancoValidation;
import br.com.diegocordeiro.dscproject.validation.CategoriaLancamentoValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoriaLancamentoValidation.class)
@Documented
public @interface ValidarCategoriaLancamento {
    String message() default "Erro de validação.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
