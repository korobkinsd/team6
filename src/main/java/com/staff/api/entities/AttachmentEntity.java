package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "attachment", schema = "team6", catalog = "")
public class AttachmentEntity {
    private int idCandidate;
    private String filePath;
    private int type;
    private CandidateEntity candidateByIdCandidate;

    @Basic
    @Column(name = "idCandidate")
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
    }

    @Basic
    @Column(name = "filePath")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentEntity that = (AttachmentEntity) o;

        if (idCandidate != that.idCandidate) return false;
        if (type != that.type) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCandidate;
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + type;
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
}
