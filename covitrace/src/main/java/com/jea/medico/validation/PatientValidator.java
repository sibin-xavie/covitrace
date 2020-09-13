package com.jea.medico.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jea.medico.model.UserChildModel;
/** 
* 
* @author Sibin 
* @since 14 sep 2020 9.39 AM
*/
public class PatientValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserChildModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
	}

}
