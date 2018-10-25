package com.staff.api.specification;

import com.staff.api.entity.Skill;


public interface ISkillSpecification extends ISpecification<Skill> {

    ISkillSpecification GetBySkill(String skill);

    ISkillSpecification GetBySkillLike(String skill);

}

