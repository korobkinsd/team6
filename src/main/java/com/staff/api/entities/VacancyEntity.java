package com.staff.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "vacancy", schema = "team6", catalog = "")
public class VacancyEntity {
    private int id;
    private String position;
    private int idDeveloper;
    private BigDecimal salaryFrom;
    private BigDecimal salaryTo;
    private byte isActive;
    private Collection<InterviewEntity> interviewsById;
    private UserEntity userByIdDeveloper;
    private Collection<VacancycandidatesEntity> vacancycandidatesById;
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
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "idDeveloper")
    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    @Basic
    @Column(name = "salaryFrom")
    public BigDecimal getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(BigDecimal salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    @Basic
    @Column(name = "salaryTo")
    public BigDecimal getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(BigDecimal salaryTo) {
        this.salaryTo = salaryTo;
    }

    @Basic
    @Column(name = "isActive")
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancyEntity that = (VacancyEntity) o;

        if (id != that.id) return false;
        if (idDeveloper != that.idDeveloper) return false;
        if (isActive != that.isActive) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (salaryFrom != null ? !salaryFrom.equals(that.salaryFrom) : that.salaryFrom != null) return false;
        if (salaryTo != null ? !salaryTo.equals(that.salaryTo) : that.salaryTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + idDeveloper;
        result = 31 * result + (salaryFrom != null ? salaryFrom.hashCode() : 0);
        result = 31 * result + (salaryTo != null ? salaryTo.hashCode() : 0);
        result = 31 * result + (int) isActive;
        return result;
    }

    @OneToMany(mappedBy = "vacancyByIdVacancy")
    public Collection<InterviewEntity> getInterviewsById() {
        return interviewsById;
    }

    public void setInterviewsById(Collection<InterviewEntity> interviewsById) {
        this.interviewsById = interviewsById;
    }

    @ManyToOne
    @JoinColumn(name = "idDeveloper", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByIdDeveloper() {
        return userByIdDeveloper;
    }

    public void setUserByIdDeveloper(UserEntity userByIdDeveloper) {
        this.userByIdDeveloper = userByIdDeveloper;
    }

    @OneToMany(mappedBy = "vacancyByIdVacancy")
    public Collection<VacancycandidatesEntity> getVacancycandidatesById() {
        return vacancycandidatesById;
    }

    public void setVacancycandidatesById(Collection<VacancycandidatesEntity> vacancycandidatesById) {
        this.vacancycandidatesById = vacancycandidatesById;
    }

    @OneToMany(mappedBy = "vacancyByIdVacancy")
    public Collection<VacancyrequirementEntity> getVacancyrequirementsById() {
        return vacancyrequirementsById;
    }

    public void setVacancyrequirementsById(Collection<VacancyrequirementEntity> vacancyrequirementsById) {
        this.vacancyrequirementsById = vacancyrequirementsById;
    }
}
