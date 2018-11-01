package com.staff.dao.specification.EntitySpecification;

import com.staff.api.entity.Skill;
import com.staff.api.enums.Sort.SortSkillFields;
import com.staff.api.specification.ISkillSpecification;
import com.staff.dao.specification.Specification;


public class SkillSpecification extends Specification<Skill> implements ISkillSpecification {


    @Override
    public ISkillSpecification GetBySkill(String skill) {
        if (skill !="" & skill !=null) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat(SortSkillFields.NAME.toString()));
            this.ConcatForEquals(skill);}
        return this;
    }

    @Override
    public ISkillSpecification GetBySkillLike( String skill) {
        if (skill !="" & skill !=null) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat(SortSkillFields.NAME.toString()));
            this.ConcatForLike(skill);
        }
        return this;
    }
}
