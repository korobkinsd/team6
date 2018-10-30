package com.staff.api.dao;


import com.staff.api.entity.Skill;

public interface ISkillDao extends ICrudDao<Skill> {

    void saveSkill(Skill skill);

}
