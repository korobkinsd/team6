package com.staff.web;

import com.staff.api.entity.Skill;
import com.staff.api.service.ISkillService;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntityRepository.SkillSpecification;
import com.staff.validator.SkillFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SkillController {
    private final Logger logger = LoggerFactory.getLogger(SkillController.class);
    private ISkillService skillService;
    @Autowired
    public void setSkillService(ISkillService skillService) {
        this.skillService = skillService;
    }

    @Autowired
    SkillFormValidator skillFormValidator;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(skillFormValidator);
    }


    // list page
    @RequestMapping(value = "/skill", method = RequestMethod.GET)
    public String showAllskill(@ModelAttribute("skillForm") Skill skill, Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "columnName", defaultValue ="NAME") String columnName, @RequestParam(value = "order", defaultValue = "ASC") String order, @RequestParam(value = "pagesize", defaultValue = "10") int pagesize) {

        logger.debug("showAllskill()");

        List<Skill> listSkill =skillService.FindWithPaging(new SkillSpecification().GetBySkill(skill.getSkill()).GetBySkillLike(skill.getSkill()),
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);
        List<Skill> listSkillWithoutPage =skillService.FindWithPaging(new SkillSpecification().GetBySkill(skill.getSkill()).GetBySkillLike(skill.getSkill()), new Sort().setColumnName(columnName).setSortOrder(order), 1, 10000);//TODO костыль

        model.addAttribute("skillForm", skill);
        model.addAttribute("pageCount",Math.ceil( listSkillWithoutPage.size()/pagesize));
        model.addAttribute("columnName",columnName);
        model.addAttribute("pageNumber",page);
        model.addAttribute("skill", listSkill);
        model.addAttribute("currentOrder",order);
        model.addAttribute("order",order.toUpperCase().equals("ASC") ? "DESC" : "ASC");

        return "skill/list";

    }
    // show add skill form
    @RequestMapping(value = "/skill/add", method = RequestMethod.GET)
    public String showAddSkillForm(Model model) {

        logger.debug("showAddSkillForm()");

        Skill skill = new Skill();

        // set default value
        skill.setSkill("JAVA");
        model.addAttribute("skillForm", skill);

        return "skill/skillform";

    }
    // save or update user
    @RequestMapping(value = "/skill", method = RequestMethod.POST)
    public String saveOrUpdateSkill(@ModelAttribute("skillForm") @Validated Skill skill,
                                    BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdateSkill() : {}", skill);

        if (result.hasErrors()) {
            return "skill/skillform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(skill.isNew()){
                redirectAttributes.addFlashAttribute("msg", "skill added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "skill updated successfully!");
            }

            //skillService.saveOrUpdate(skill,new SkillSpecification().GetBySkill(skill.getForeignKeyint()));

            // POST/REDIRECT/GET
            return "redirect:/skill"; // + skill.getSkill();

            // POST/FORWARD/GET
            // return "skill/list";

        }

    }
    // show skill
    @RequestMapping(value = "/skill/{skill}", method = RequestMethod.GET)
    public String showSkill(@PathVariable("skill") String name, Model model) {

        logger.debug("showSkill() name: {}", name);

        Skill skill = skillService.Read(new SkillSpecification().GetBySkill(name) );
        if (skill == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "skill not found");
        }
        model.addAttribute("skill", skill);

        return "skill/show";

    }

    // show update form
    @RequestMapping(value = "/skill/{skill}/update", method = RequestMethod.GET)
    public String showUpdateSkillForm(@PathVariable("skill") String name, Model model) {

        logger.debug("showUpdateSkillForm() : {}", name);
        Skill skill = skillService.Read(new SkillSpecification().GetBySkill(name));
        model.addAttribute("skillForm", skill);

        return "skill/skillform";

    }

    // delete user
    @RequestMapping(value = "/skill/{skill}/delete", method = RequestMethod.POST)
    public String deleteSkill(@PathVariable("skill") String name, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteSkill() : {}", name);

        skillService.delete(new SkillSpecification().GetBySkill(name));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Skill is deleted!");

        return "redirect:/skill";

    }
}

