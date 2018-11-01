package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "vacancycandidates", schema = "team6", catalog = "")
public class VacancycandidatesEntity {
    private int idVacancy;
    private int idCandidate;
    private Integer idSuitableState;
    private String reason;
    private VacancyEntity vacancyByIdVacancy;
    private CandidateEntity candidateByIdCandidate;
    private SuitablestateEntity suitablestateByIdSuitableState;

    @Basic
    @Column(name = "idVacancy")
    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
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
    @Column(name = "idSuitableState")
    public Integer getIdSuitableState() {
        return idSuitableState;
    }

    public void setIdSuitableState(Integer idSuitableState) {
        this.idSuitableState = idSuitableState;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacancycandidatesEntity that = (VacancycandidatesEntity) o;

        if (idVacancy != that.idVacancy) return false;
        if (idCandidate != that.idCandidate) return false;
        if (idSuitableState != null ? !idSuitableState.equals(that.idSuitableState) : that.idSuitableState != null)
            return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVacancy;
        result = 31 * result + idCandidate;
        result = 31 * result + (idSuitableState != null ? idSuitableState.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "idSuitableState", referencedColumnName = "id")
    public SuitablestateEntity getSuitablestateByIdSuitableState() {
        return suitablestateByIdSuitableState;
    }

    public void setSuitablestateByIdSuitableState(SuitablestateEntity suitablestateByIdSuitableState) {
        this.suitablestateByIdSuitableState = suitablestateByIdSuitableState;
    }
}
