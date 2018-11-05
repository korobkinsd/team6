
package com.staff.web;



import com.staff.api.entity.Vacancy;
import com.staff.api.service.IVacancyService;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntitySpecification.VacancySpecification;
import com.staff.exception.VacancyNotFoundException;
import com.staff.validator.VacancyFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class VacancyController {
    private final Logger logger = LoggerFactory.getLogger(VacancyController.class);
    private IVacancyService vacancyService;
    @Autowired
    public void setVacancyService(IVacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Autowired
    VacancyFormValidator vacancyFormValidator;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(vacancyFormValidator);
    }


    // list page
    @RequestMapping(value = "/vacancy", method = RequestMethod.GET)
    public List<Vacancy> showAllvacancy(@ModelAttribute("vacancyform")  Vacancy vacancy,Model model,@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "columnName", defaultValue ="ID") String columnName,@RequestParam(value = "order", defaultValue = "ASC") String order,@RequestParam(value = "pagesize", defaultValue = "10") int pagesize) {

        logger.debug("showAllvacancy()");

        List<Vacancy> listVacancy =vacancyService.FindWithPaging(new VacancySpecification().GetById(vacancy.getId())
                .GetByPositionLike(vacancy.getPosition()).GetByIdDeveloper(vacancy.getIdDeveloper())
                .GetBySalaryTo(vacancy.getSalaryTo()).GetBySalaryFrom(vacancy.getSalaryFrom())
                .GetByExperienceYearsRequire(vacancy.getExperienceYearsRequire()).GetByState(vacancy.getState()),
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);
        
          return listVacancy;

    }

    // save or update user
    @RequestMapping(value = "/vacancy", method = RequestMethod.PUT)
    public Vacancy saveOrUpdateVacancy(@Validated    @RequestBody Vacancy vacancy,
                                   BindingResult result, Model model) {

        logger.debug("saveOrUpdateVacancy() : {}", vacancy);

        if (result.hasErrors()) {
            throw new VacancyNotFoundException();
        } else {

            vacancyService.saveOrUpdate(vacancy,new VacancySpecification().GetById(vacancy.getForeignKeyint()));

            return vacancy;
        }

    }

    // save or update user
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.POST)
    public Vacancy UpdateVacancy(@PathVariable("id") int id,@Validated @RequestBody Vacancy vacancy,
                                       BindingResult result, Model model) {

        logger.debug("saveOrUpdateVacancy() : {}", vacancy);

        if (null ==  vacancyService.Read(new VacancySpecification().GetById(id) )) {
            throw new VacancyNotFoundException();
        }
        if (result.hasErrors()) {

            throw new VacancyNotFoundException();
        } else {

            vacancyService.saveOrUpdate(vacancy,new VacancySpecification().GetById(id));

            return vacancy;

        }

    }
    // show vacancy
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET)
    public Vacancy showVacancy(@PathVariable("id") int id, Model model) {

        logger.debug("showVacancy() id: {}", id);

        Vacancy vacancy = vacancyService.Read(new VacancySpecification().GetById(id) );
        if (vacancy == null) {
            throw new VacancyNotFoundException();
        }

        return vacancy;
    }



    // delete user
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.DELETE)
    public void deleteVacancy(@PathVariable("id") int id) {

        logger.debug("deleteVacancy() : {}", id);
        Vacancy vacancy = vacancyService.Read(new VacancySpecification().GetById(id) );
        if (vacancy == null) {
            throw new VacancyNotFoundException();
        }
        vacancyService.delete(new VacancySpecification().GetById(id));

    }
}

