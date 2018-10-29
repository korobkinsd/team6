package com.staff.validator;

import com.staff.api.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.staff.api.service.ICandidateService;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class CandidateFormValidator implements Validator {


	@Autowired
    ICandidateService candidateService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Candidate.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Candidate candidate = (Candidate) target;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "NotEmpty.candidateForm.birthday");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.candidateForm.name");

	}

}