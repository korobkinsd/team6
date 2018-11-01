package com.staff.api.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "interview", schema = "team6", catalog = "")
public class InterviewEntity {
    private int id;
    private int idVacancy;
    private Timestamp planDate;
    private int idCandidate;
    private Timestamp factDate;
    private VacancyEntity vacancyByIdVacancy;
    private CandidateEntity candidateByIdCandidate;
    private Collection<InterviewfeedbackEntity> interviewfeedbacksById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idVacancy")
    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    @Basic
    @Column(name = "planDate")
    public Timestamp getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Timestamp planDate) {
        this.planDate = planDate;
    }

    @Basic
    @Column(name = "idCandidate")
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
    }

    @Basic
    @Column(name = "factDate")
    public Timestamp getFactDate() {
        return factDate;
    }

    public void setFactDate(Timestamp factDate) {
        this.factDate = factDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewEntity that = (InterviewEntity) o;

        if (id != that.id) return false;
        if (idVacancy != that.idVacancy) return false;
        if (idCandidate != that.idCandidate) return false;
        if (planDate != null ? !planDate.equals(that.planDate) : that.planDate != null) return false;
        if (factDate != null ? !factDate.equals(that.factDate) : that.factDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idVacancy;
        result = 31 * result + (planDate != null ? planDate.hashCode() : 0);
        result = 31 * result + idCandidate;
        result = 31 * result + (factDate != null ? factDate.hashCode() : 0);
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
    @JoinColumn(name = "idCandidate", referencedColumnName = "id", nullable = false)
    public CandidateEntity getCandidateByIdCandidate() {
        return candidateByIdCandidate;
    }

    public void setCandidateByIdCandidate(CandidateEntity candidateByIdCandidate) {
        this.candidateByIdCandidate = candidateByIdCandidate;
    }

    @OneToMany(mappedBy = "interviewByIdInterview")
    public Collection<InterviewfeedbackEntity> getInterviewfeedbacksById() {
        return interviewfeedbacksById;
    }

    public void setInterviewfeedbacksById(Collection<InterviewfeedbackEntity> interviewfeedbacksById) {
        this.interviewfeedbacksById = interviewfeedbacksById;
    }
}
