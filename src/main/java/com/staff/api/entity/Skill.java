package com.staff.api.entity;

public class Skill {

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
    String skill;

    public boolean isNew() {
        return (this.skill == null);
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skill " + skill;
    }

}
