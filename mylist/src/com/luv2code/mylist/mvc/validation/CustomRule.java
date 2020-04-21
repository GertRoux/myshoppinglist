package com.luv2code.mylist.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CustomRuleConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomRule {

	    //define default course code
		public String value() default "PPG";
		
		// TIP: If you want to validate against multiple String values:
	    // public String[] value() default {"LUV"};
		// then you'd also require to change the coursePrefix field in CourseCodeConstraintValidator to String[]
		
		//define default error mesage
		public String message() default "Course code must start with PPG";
		
		//define default groups
		public Class<?>[] groups() default {};
		
		//define default payloads
		public Class<? extends Payload>[] payload() default {};
		
}
