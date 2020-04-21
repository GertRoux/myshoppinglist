package com.luv2code.mylist.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomRuleConstraintValidator implements ConstraintValidator<CustomRule, String>{
	
	private String allowedValue;
	
	@Override
	public void initialize(CustomRule customRule) {
		this.allowedValue = customRule.value();
	}

	@Override
	public boolean isValid(String incomingString, ConstraintValidatorContext arg1) {
		//TODO: Implementeer jou eie validation rules vir 'n incoming String.
		boolean result = false;
		
		if(null != incomingString) {
			result = incomingString.startsWith(allowedValue);
		}
		
		return result;
	}

}
