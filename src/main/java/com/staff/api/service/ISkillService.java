package com.staff.api.service;

import com.staff.api.entity.Skill;


public interface ISkillService extends ICrudService<Skill>{

    void saveSkill(Skill skill);

}
