package com.staff.service;

import com.staff.api.dao.ISkillDao;
import com.staff.api.entity.Skill;
import com.staff.api.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("skillService")
public class SkillService extends CrudService<Skill> implements ISkillService {


    @Autowired
    public void setSkillDao(ISkillDao skillDao) {
        this.dao = skillDao;
    }

    @Override
    public void saveSkill(Skill skill) {
        ISkillDao d = (ISkillDao)this.dao;
        d.saveSkill(skill);
    }

}
