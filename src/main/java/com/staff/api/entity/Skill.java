package com.staff.api.entity;

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
    String name;

    public boolean isNew() {
        return this.name == null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill " + name;
    }


    @Override
    public void setForeignKey(String foreignKey) {
        this.name = foreignKey;
    }

    @Override
    public String getForeignKey() {
        /*TODO: не думаю, что это правильно, но не придумал, как сделать лучше*/
        return this.name != null ? this.name : "0000000000000000000000000000";
    }


}
