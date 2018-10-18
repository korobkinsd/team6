package com.staff.web;

import com.staff.api.service.ISkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SkillController {

    private final Logger logger = LoggerFactory.getLogger(SkillController.class);

    private ISkillService skillService;

    @Autowired
    public void setSkillService(ISkillService skillService) {
        this.skillService = skillService;
    }

    // list page
    @RequestMapping(value = "/skill", method = RequestMethod.GET)
    public String showAllSkills(Model model) {

        logger.debug("showAllSkills()");
        model.addAttribute("skill", skillService.findAll());
        return "skill/list";

    }

}
