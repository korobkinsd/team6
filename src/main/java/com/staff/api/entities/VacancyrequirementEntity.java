package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "vacancyrequirement", schema = "team6", catalog = "")
public class VacancyrequirementEntity {
    private int idVacancy;
    private int idSkill;
    private VacancyEntity vacancyByIdVacancy;
    private SkillEntity skillByIdSkill;

    @Basic
    @Column(name = "idVacancy")
    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    @Basic
    @Column(name = "idSkill")
    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancyrequirementEntity that = (VacancyrequirementEntity) o;

        if (idVacancy != that.idVacancy) return false;
        if (idSkill != that.idSkill) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVacancy;
        result = 31 * result + idSkill;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idVacancy", referencedColumnName = "id", nullable = false)
    public VacancyEntity getVacancyByIdVacancy() {
        return vacancyByIdVacancy;
    }

    public void setVacancyByIdVacancy(VacancyEntity vacancyByIdVacancy) {
        this.vacancyByIdVacancy = vacancyByIdVacancy;
    }

    @ManyToOne
    @JoinColumn(name = "idSkill", referencedColumnName = "id", nullable = false)
    public SkillEntity getSkillByIdSkill() {
        return skillByIdSkill;
    }

    public void setSkillByIdSkill(SkillEntity skillByIdSkill) {
        this.skillByIdSkill = skillByIdSkill;
    }
}
