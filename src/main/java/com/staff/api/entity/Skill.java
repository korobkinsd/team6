package com.staff.api.entity;

public class Skill {

    enum SkillEnum {
        C, JAVA, SQL , PYTHON, PHP
    }

    private SkillEnum skill;

    public String getSkill() {
        return this.skill.name();
    }

    public void setSkill(String status) {
        this.skill = SkillEnum.valueOf(status);
    }


    @Override
    public String toString() {
        return "Skill " + getSkill();
    }
}
