//package com.staff.validator;
//
//import com.staff.api.entity.Interview;
//import com.staff.api.service.IInterviewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class InterviewFormValidator implements Validator {
//
//    @Autowired
//    IInterviewService interviewService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Interview.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//       // Interview interview = (Interview) target;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idCandidate", "NotEmpty.interviewForm.idCandidate");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idVacancy", "NotEmpty.interviewForm.idVacancy");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "planDate", "NotEmpty.interviewForm.planDate");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "factDate", "NotEmpty.interviewForm.factDate");
//
//    }
//}
