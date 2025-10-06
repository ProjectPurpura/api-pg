package org.purpura.apipg.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueVendedorCompradorValidator.class)
public @interface UniqueVendedorComprador {
    String message() default "O vendedor e o comprador não podem ser iguais.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}