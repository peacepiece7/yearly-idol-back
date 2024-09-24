package com.yearly.idol.api.yearly_idol.Common.validator;

import com.yearly.idol.api.yearly_idol.Common.annotation.StringValueConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StringValueValidator implements ConstraintValidator<StringValueConstraint, String> {

    private String[] acceptedValues;

    @Override
    public void initialize(StringValueConstraint constraintAnnotation) {
        this.acceptedValues = constraintAnnotation.acceptedValues();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        for (String acceptedValue : acceptedValues) {
            if (acceptedValue.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
