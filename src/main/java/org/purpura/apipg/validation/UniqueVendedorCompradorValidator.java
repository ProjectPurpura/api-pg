package org.purpura.apipg.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.purpura.apipg.dto.util.HasVendedorComprador;


public class UniqueVendedorCompradorValidator implements ConstraintValidator<UniqueVendedorComprador, HasVendedorComprador> {
    @Override
    public boolean isValid(HasVendedorComprador value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (value.getIdVendedor() == null || value.getIdComprador() == null) return true;
        return !value.getIdVendedor().equals(value.getIdComprador());
    }
}

