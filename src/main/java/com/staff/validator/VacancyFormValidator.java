//
//package com.staff.validator;
//
//
//        import com.staff.api.entity.Vacancy;
//        import com.staff.api.service.IVacancyService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.beans.factory.annotation.Qualifier;
//        import org.springframework.stereotype.Component;
//        import org.springframework.validation.Errors;
//        import org.springframework.validation.ValidationUtils;
//        import org.springframework.validation.Validator;
//
//
////http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
//@Component
//public class VacancyFormValidator implements Validator {
//
//    @Autowired
//    @Qualifier("emailValidator")
//    EmailValidator emailValidator;
//
//    @Autowired
//    IVacancyService vacancyService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Vacancy.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//        Vacancy vacancy = (Vacancy) target;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "NotEmpty.vacancyForm.position");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idDeveloper", "NotEmpty.userForm.name");
//
//        if(vacancy.getSalaryFrom()>vacancy.getSalaryTo()){
//            errors.rejectValue("salaryFrom", "Value.vacancyForm.salaryFrom");
//        }
//    }
//
//}
