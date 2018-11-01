package com.staff.web;

import com.staff.api.entity.Skill;
import com.staff.api.service.ISkillService;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntitySpecification.SkillSpecification;
import com.staff.validator.SkillFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    // list page
    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public String showAllskill(@ModelAttribute("skillForm") Skill skill, Model model, @RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "columnName", defaultValue ="NAME") String columnName, @RequestParam(value = "order", defaultValue = "ASC") String order, @RequestParam(value = "pagesize", defaultValue = "5") int pagesize) {

        logger.debug("showAllskill()");

        List<Skill> listSkill =skillService.FindWithPaging(new SkillSpecification().GetBySkillLike(skill.getName()),
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);

        int skillCount = skillService.Count(new SkillSpecification());
        int pageCount = (int) Math.ceil((double) skillCount/pagesize);

        model.addAttribute("skillForm", skill);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("columnName",columnName);
        model.addAttribute("pageNumber",page);
        model.addAttribute("skills", listSkill);
        model.addAttribute("currentOrder",order);
        model.addAttribute("order",order.toUpperCase().equals("ASC") ? "DESC" : "ASC");

        return "skills/list";

    }
    // show add skill form
    @RequestMapping(value = "/skills/add", method = RequestMethod.GET)
    public String showAddSkillForm(Model model) {

        logger.debug("showAddSkillForm()");

        Skill skill = new Skill();

        // set default value
        //skill.setName("SET SKILL");
        model.addAttribute("skillForm", skill);

        return "skills/skillform";

    }
    // save or update skill
    @RequestMapping(value = "/skills", method = RequestMethod.POST)
    public String saveOrUpdateSkill(@ModelAttribute("skillForm") @Validated Skill skill,
                                    BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdateSkill() : {}", skill);

        if (result.hasErrors()) {
            return "skills/skillform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(skill.isNew()){
                redirectAttributes.addFlashAttribute("msg", "skill added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "skill updated successfully!");
            }

            skillService.saveSkill(skill);

            // POST/REDIRECT/GET
            return "redirect:/skills";// + name.getSkill();

            // POST/FORWARD/GET
            // return "skill/list";

        }

    }
    // show skill
    @RequestMapping(value = "/skills/{name}", method = RequestMethod.GET)
    public String showSkill(@PathVariable("name") String name, Model model) {

        logger.debug("showSkill() name: {}", name);

        Skill skill = skillService.Read(new SkillSpecification().GetBySkill(name) );
        if (skill == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "skill not found");
        }
        model.addAttribute("skill", skill);

        return "skills/show";

    }

    // show update form
    @RequestMapping(value = "/skills/{name}/update", method = RequestMethod.GET)
    public String showUpdateSkillForm(@PathVariable("name") String name, Model model) {

        logger.debug("showUpdateSkillForm() : {}", name);
        Skill skill = skillService.Read(new SkillSpecification().GetBySkill(name));
        model.addAttribute("skillForm", skill);

        return "skills/skillform";

    }

    // delete user
    @RequestMapping(value = "/skills/{name}/delete", method = RequestMethod.POST)
    public String deleteSkill(@PathVariable("name")  String name, final RedirectAttributes redirectAttributes) {

        logger.debug("deleteSkill() : {}", name);

        skillService.delete(new SkillSpecification().GetBySkill(name));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Skill is deleted!");

        return "redirect:/skills";

    }
}

