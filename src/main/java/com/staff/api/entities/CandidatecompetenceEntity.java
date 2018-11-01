package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "candidatecompetence", schema = "team6", catalog = "")
public class CandidatecompetenceEntity {
    private int idCandidate;
    private int idSkill;
    private CandidateEntity candidateByIdCandidate;
    private SkillEntity skillByIdSkill;

    @Basic
    @Column(name = "idCandidate")
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
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

        CandidatecompetenceEntity that = (CandidatecompetenceEntity) o;

        if (idCandidate != that.idCandidate) return false;
        if (idSkill != that.idSkill) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCandidate;
        result = 31 * result + idSkill;
        return result;
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
    @JoinColumn(name = "idSkill", referencedColumnName = "id", nullable = false)
    public SkillEntity getSkillByIdSkill() {
        return skillByIdSkill;
    }

    public void setSkillByIdSkill(SkillEntity skillByIdSkill) {
        this.skillByIdSkill = skillByIdSkill;
    }
}
