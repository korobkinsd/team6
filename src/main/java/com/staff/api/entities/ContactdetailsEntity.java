package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "contactdetails", schema = "team6", catalog = "")
public class ContactdetailsEntity {
    private int idCandidate;
    private int idContactType;
    private String contactDetails;
    private CandidateEntity candidateByIdCandidate;
    private ContacttypeEntity contacttypeByIdContactType;

    @Basic
    @Column(name = "idCandidate")
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
    }

    @Basic
    @Column(name = "idContactType")
    public int getIdContactType() {
        return idContactType;
    }

    public void setIdContactType(int idContactType) {
        this.idContactType = idContactType;
    }

    @Basic
    @Column(name = "contactDetails")
    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactdetailsEntity that = (ContactdetailsEntity) o;

        if (idCandidate != that.idCandidate) return false;
        if (idContactType != that.idContactType) return false;
        if (contactDetails != null ? !contactDetails.equals(that.contactDetails) : that.contactDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCandidate;
        result = 31 * result + idContactType;
        result = 31 * result + (contactDetails != null ? contactDetails.hashCode() : 0);
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
    @JoinColumn(name = "idContactType", referencedColumnName = "id", nullable = false)
    public ContacttypeEntity getContacttypeByIdContactType() {
        return contacttypeByIdContactType;
    }

    public void setContacttypeByIdContactType(ContacttypeEntity contacttypeByIdContactType) {
        this.contacttypeByIdContactType = contacttypeByIdContactType;
    }
}
