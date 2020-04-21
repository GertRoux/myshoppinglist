package com.luv2code.mylist.mvc.validation;

import java.text.ParseException;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.luv2code.mylist.mvc.DateUtils;

public class CustomDateRuleValidator implements ConstraintValidator<CustomDateRule, String>{
	
	private String allowedValue;
	
	@Override
	public void initialize(CustomDateRule customDateRule) {
		this.allowedValue = customDateRule.value();
	}

	@Override
	public boolean isValid(String incomingString, ConstraintValidatorContext arg1) {
		//TODO: Implementeer jou eie validation rules vir 'n incoming String.
		boolean result = false;
		
		if(null != incomingString) {
			try {
				Date theDate = DateUtils.parseDate(incomingString);
				result = true;
			} catch (ParseException e) {
				result = false;
			}
		}
		
		return result;
	}

}
