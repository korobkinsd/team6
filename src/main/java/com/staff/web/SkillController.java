package com.staff.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.staff.api.dao.ISkillDao;
import com.staff.api.entity.Skill;
import com.staff.api.specification.ISkillSpecification;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntitySpecification.SkillSpecification;
import com.staff.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {
    
    private final Logger logger = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private ISkillDao skillDao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Skill> showAllSkills(@RequestParam(value = "filter") String filter,
                                                 @RequestParam(value = "columnName", defaultValue ="NAME") String columnName,
                                                 @RequestParam(value = "order", defaultValue = "ASC") String order,
                                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "pagesize", defaultValue = "5") int pagesize) throws IOException {

        logger.debug("showAllSkills()");
        ObjectMapper mapper = new ObjectMapper();
        Skill skillFilter = mapper.readValue(filter, Skill.class);

        ISkillSpecification specSkill = new SkillSpecification();
        if (skillFilter != null){
            specSkill = specSkill.GetBySkillLike(skillFilter.getName());
        }
        List<Skill> skills = skillDao.FindWithPaging(specSkill,
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);

        //return mapper.writeValueAsString(skills);
        return skills;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public @ResponseBody Skill showSkill(@PathVariable("name") String name) {

        logger.debug("showSkill() name: {}", name);

        Skill skill = skillDao.Read(new SkillSpecification().GetBySkill(name));
        if (skill != null){
            return skill;
        }else{
            throw new ResourceNotFoundException();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Skill saveSkill(@Valid @RequestBody Skill skill,
                                       BindingResult result) throws BindException {

        logger.debug("saveSkill() : {}", skill);

        if (result.hasErrors()) {
            throw new BindException(result);
        } else {
            skillDao.saveSkill(skill);
            return skill;
        }
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSkill(@PathVariable("name") String name, @Valid @RequestBody Skill skill,
                           BindingResult result) throws BindException{

        logger.debug("saveOrUpdateSkill() : {}", skill);

        if (result.hasErrors()) {
            throw new BindException(result);
        } else {

            Skill updSkill = skillDao.Read(new SkillSpecification().GetBySkill(name));
            if (updSkill== null) {
                throw new ResourceNotFoundException();
            } else {
                updSkill.setName(skill.getName());
                skillDao.saveSkill(updSkill);
            }
        }

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable("name") String name) {

        logger.debug("deleteSkill() : {}", name);


        Skill skill = skillDao.Read(new SkillSpecification().GetBySkill(name));
        if (skill != null){
            skillDao.delete(new SkillSpecification().GetBySkill(name));
        }else{
            throw new ResourceNotFoundException();
        }
    }

}

