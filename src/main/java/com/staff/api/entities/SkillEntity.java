package com.staff.api.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "skill", schema = "team6", catalog = "")
public class SkillEntity {
    private int id;
    private String name;
    private Collection<CandidatecompetenceEntity> candidatecompetencesById;
    private Collection<VacancyrequirementEntity> vacancyrequirementsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkillEntity that = (SkillEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "skillByIdSkill")
    public Collection<CandidatecompetenceEntity> getCandidatecompetencesById() {
        return candidatecompetencesById;
    }

    public void setCandidatecompetencesById(Collection<CandidatecompetenceEntity> candidatecompetencesById) {
        this.candidatecompetencesById = candidatecompetencesById;
    }

    @OneToMany(mappedBy = "skillByIdSkill")
    public Collection<VacancyrequirementEntity> getVacancyrequirementsById() {
        return vacancyrequirementsById;
    }

    public void setVacancyrequirementsById(Collection<VacancyrequirementEntity> vacancyrequirementsById) {
        this.vacancyrequirementsById = vacancyrequirementsById;
    }
}
