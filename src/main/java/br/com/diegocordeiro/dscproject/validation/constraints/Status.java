package br.com.diegocordeiro.dscproject.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import br.com.diegocordeiro.dscproject.validation.StatusValidation;

@Documented
@Constraint(validatedBy = StatusValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Status {

    String message() default "O valor digitado não consta na lista de valores aceitos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
