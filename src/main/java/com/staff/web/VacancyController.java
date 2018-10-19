package com.staff.web;


import com.staff.api.entity.User;
import com.staff.api.entity.Vacancy;
import com.staff.api.enums.Sort.SortOrder;
import com.staff.api.enums.Sort.SortVacancyFields;
import com.staff.api.service.IUserService;
import com.staff.api.service.IVacancyService;

import com.staff.sort.Sort;
import com.staff.specification.EntityRepository.VacancySpecification;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showAllvacancy(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {

        model.addAttribute("vacancyCount",Math.ceil(vacancyService.Count(new VacancySpecification())/10.0));

        model.addAttribute("vacancy", vacancyService.FindWithPaging(new VacancySpecification(), new Sort().setColumnName(SortVacancyFields.ID).setSortOrder(SortOrder.ASC), page, 10));

        logger.debug("showAllvacancy()");
          return "vacancy/list";

    }
    // show add vacancy form
    @RequestMapping(value = "/vacancy/add", method = RequestMethod.GET)
    public String showAddVacancyForm(Model model) {

        logger.debug("showAddVacancyForm()");
        List<User> listOfUsersobj =userService.findAll();
        model.addAttribute("listOfUsers", listOfUsersobj);

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
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdateVacancy() : {}", vacancy);

        if (result.hasErrors()) {
            return "vacancy/vacancyform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(vacancy.isNew()){
                redirectAttributes.addFlashAttribute("msg", "vacancy added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "vacancy updated successfully!");
            }

            vacancyService.saveOrUpdate(vacancy);

            // POST/REDIRECT/GET
            return "redirect:/vacancy/" + vacancy.getId();

            // POST/FORWARD/GET
            // return "vacancy/list";

        }

    }
    // show vacancy
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
    public String showVacancy(@PathVariable("id") int id, Model model) {

        logger.debug("showVacancy() id: {}", id);

        Vacancy vacancy = vacancyService.findById(id);
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

        Vacancy vacancy = vacancyService.findById(id);
        List<User> listOfUsersobj =userService.findAll();
        model.addAttribute("listOfUsers", listOfUsersobj);
        model.addAttribute("vacancyForm", vacancy);

        return "vacancy/vacancyform";

    }

    // delete user
    @RequestMapping(value = "/vacancy/{id}/delete", method = RequestMethod.POST)
    public String deleteVacancy(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteVacancy() : {}", id);

        vacancyService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Vacancy is deleted!");

        return "redirect:/vacancy";

    }
}
