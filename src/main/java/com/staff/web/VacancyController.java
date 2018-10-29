
package com.staff.web;


import com.staff.api.entity.User;
import com.staff.api.entity.Vacancy;
import com.staff.api.enums.VacancyState;
import com.staff.api.service.IUserService;
import com.staff.api.service.IVacancyService;

import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntityRepository.UserSpecification;
import com.staff.dao.specification.EntityRepository.VacancySpecification;

import com.staff.validator.VacancyFormValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class VacancyController {
    private final Logger logger = LoggerFactory.getLogger(VacancyController.class);
    private IVacancyService vacancyService;
    private IUserService userService;
    @Autowired
    public void setVacancyService(IVacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    @Autowired
    private MessageSource messageSource;


    @Autowired
    VacancyFormValidator vacancyFormValidator;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(vacancyFormValidator);
    }


    // list page
    @RequestMapping(value = "/vacancy", method = RequestMethod.GET)
    public String showAllvacancy(@ModelAttribute("vacancyForm")  Vacancy vacancy,Model model,@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "columnName", defaultValue ="ID") String columnName,@RequestParam(value = "order", defaultValue = "ASC") String order,@RequestParam(value = "pagesize", defaultValue = "10") int pagesize) {
        List<User> listOfUsersobj =userService.Find(new UserSpecification());
        List<Vacancy> listVacancy =vacancyService.FindWithPaging(new VacancySpecification().GetById(vacancy.getId())
                .GetByPositionLike(vacancy.getPosition()).GetByIdDeveloper(vacancy.getIdDeveloper())
                .GetBySalaryTo(vacancy.getSalaryTo()).GetBySalaryFrom(vacancy.getSalaryFrom())
                .GetByExperienceYearsRequire(vacancy.getExperienceYearsRequire()).GetByState(vacancy.getState()),
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);
        List<Vacancy> listVacancyWithoutPage =vacancyService.FindWithPaging(new VacancySpecification().GetById(vacancy.getId()).GetByPositionLike(vacancy.getPosition()).GetByIdDeveloper(vacancy.getIdDeveloper()).GetBySalaryTo(vacancy.getSalaryTo()).GetBySalaryFrom(vacancy.getSalaryFrom()).GetByExperienceYearsRequire(vacancy.getExperienceYearsRequire()), new Sort().setColumnName(columnName).setSortOrder(order), 1, 10000);//TODO костыль
        List<VacancyState> vacancyState = Arrays.asList(VacancyState.values());
        model.addAttribute("vacancyState", vacancyState);
        model.addAttribute("listOfUsers", listOfUsersobj);

        model.addAttribute("vacancyForm", vacancy);
        model.addAttribute("pageCount",Math.ceil( listVacancyWithoutPage.size()/pagesize));
        model.addAttribute("columnName",columnName);
        model.addAttribute("pageNumber",page);
        model.addAttribute("vacancy", listVacancy);
        model.addAttribute("currentOrder",order);
        model.addAttribute("order",order.toUpperCase().equals("ASC") ? "DESC" : "ASC");
        logger.debug("showAllvacancy()");
          return "vacancy/list";

    }
    // show add vacancy form
    @RequestMapping(value = "/vacancy/add", method = RequestMethod.GET)
    public String showAddVacancyForm(Model model) {

        logger.debug("showAddVacancyForm()");
        List<User> listOfUsersobj =userService.Find(new UserSpecification());
        model.addAttribute("listOfUsers", listOfUsersobj);
        List<VacancyState> vacancyState = Arrays.asList(VacancyState.values());
        model.addAttribute("vacancyState", vacancyState);
        Vacancy vacancy = new Vacancy();

        // set default value
        vacancy.setPosition("JavaPosition");
        vacancy.setSalaryFrom(2000);
        vacancy.setSalaryTo(3000);
        vacancy.setExperienceYearsRequire(5);
        model.addAttribute("vacancyForm", vacancy);

        return "vacancy/vacancyform";

    }
    // save or update user
    @RequestMapping(value = "/vacancy", method = RequestMethod.POST)
    public String saveOrUpdateVacancy(@ModelAttribute("vacancyForm") @Validated Vacancy vacancy,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request) {

        logger.debug("saveOrUpdateVacancy() : {}", vacancy);

        if (result.hasErrors()) {
            List<User> listOfUsersobj =userService.Find(new UserSpecification());
            model.addAttribute("listOfUsers", listOfUsersobj);
            List<VacancyState> vacancyState = Arrays.asList(VacancyState.values());
            model.addAttribute("vacancyState", vacancyState);
            return "vacancy/vacancyform";
        } else {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            Locale locale = localeResolver.resolveLocale(request);
            if (locale == null) {locale = Locale.getDefault();}
            redirectAttributes.addFlashAttribute("css", "success");
            if(vacancy.isNew()){
                redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("messages.vacancy.added" , null, locale ));
            }else{
                redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("messages.vacancy.updated" , null, locale ));
            }

            vacancyService.saveOrUpdate(vacancy,new VacancySpecification().GetById(vacancy.getForeignKeyint()));

            // POST/REDIRECT/GET
            return "redirect:/vacancy"; // + vacancy.getId();

            // POST/FORWARD/GET
            // return "vacancy/list";

        }

    }
    // show vacancy
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
    public String showVacancy(@PathVariable("id") int id, Model model) {

        logger.debug("showVacancy() id: {}", id);

        Vacancy vacancy = vacancyService.Read(new VacancySpecification().GetById(id) );
        if (vacancy == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "vacancy not found");
        }
        model.addAttribute("vacancy", vacancy);

        return "vacancy/show";

    }

    // show update form
    @RequestMapping(value = "/vacancy/{id}/update", method = RequestMethod.GET)
    public String showUpdateVacancyForm(@PathVariable("id") int id, Model model) {

        logger.debug("showUpdateVacancyForm() : {}", id);
        List<VacancyState> vacancyState = Arrays.asList(VacancyState.values());
        model.addAttribute("vacancyState", vacancyState);
        Vacancy vacancy = vacancyService.Read(new VacancySpecification().GetById(id));
        List<User> listOfUsersobj =userService.Find(new UserSpecification());
        model.addAttribute("listOfUsers", listOfUsersobj);
        model.addAttribute("vacancyForm", vacancy);

        return "vacancy/vacancyform";

    }

    // delete user
    @RequestMapping(value = "/vacancy/{id}/delete", method = RequestMethod.POST)
    public String deleteVacancy(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteVacancy() : {}", id);

        vacancyService.delete(new VacancySpecification().GetById(id));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Vacancy is deleted!");

        return "redirect:/vacancy";

    }
}

