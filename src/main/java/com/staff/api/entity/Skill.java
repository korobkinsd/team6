package com.staff.api.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Skill implements IEntity<Skill> {

//    enum SkillEnum {
//        C, JAVA, SQL , PYTHON, PHP
//    }
//
//    private SkillEnum skill;
//
//    public String getSkill() {
//        return this.skill.name();
//    }
//
//    public void setSkill(String status) {
//        this.skill = SkillEnum.valueOf(status);
//    }
//
//
//    @Override
//    public String toString() {
//        return "Skill " + getSkill();
//    }

    // form:input - textbox
    @Size(min=1, max=80, message="Field shouldn't be empty")
    @Pattern(regexp="[A-Za-z._%+-]", message="Only letters and symbols")
    private String name;

    public boolean isNew() {
        return this.name == null;
    }


    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public final String toString() {
        return "Skill " + name;
    }


    @Override
    public final void setForeignKey(String foreignKey) {
        this.name = foreignKey;
    }

    @Override
    public final String getForeignKey() {
        /*TODO: не думаю, что это правильно, но не придумал, как сделать лучше*/
        return this.name != null ? this.name : "0000000000000000000000000000";
    }


}
