package com.maersk.containers.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The custom validator class to validate that entered value is one of the
 * defined in the bean
 * 
 * @author Pattabhi
 */
public class OneOfIntegerValuesValidator implements ConstraintValidator<OneOfIntegerValues, Object> {

	List<Integer> values = new ArrayList<>();

	@Override
	public void initialize(OneOfIntegerValues constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		for (int val : constraintAnnotation.values()) {
			this.values.add(Integer.valueOf(val));
		}
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return this.values.contains(value);
	}

}
