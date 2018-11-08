//package com.staff.validator;
//
//import com.staff.api.entity.Skill;
//import com.staff.api.service.ISkillService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class SkillFormValidator implements Validator {
//
//    @Autowired
//    ISkillService skillService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Skill.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//       // Skill skill = (Skill) target;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.skillForm.name");
//
//    }
//}
