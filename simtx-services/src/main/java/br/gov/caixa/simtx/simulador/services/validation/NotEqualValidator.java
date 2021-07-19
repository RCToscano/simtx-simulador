package br.gov.caixa.simtx.simulador.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEqualValidator implements ConstraintValidator<NotEqual, String> {
	
	protected String secondValue;

	@Override
	public void initialize(NotEqual constraintAnnotation) {
		this.secondValue = constraintAnnotation.secondValue();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		return !value.equals(this.secondValue);
	}

}
