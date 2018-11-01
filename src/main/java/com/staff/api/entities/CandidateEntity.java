package com.staff.api.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "candidate", schema = "team6", catalog = "")
public class CandidateEntity {
    private int id;
    private String email;
    private String name;
    private String surname;
    private Date birthday;
    private String photoFilePath;
    private BigDecimal salary;
    private Integer idCandidateState;
    private Collection<AttachmentEntity> attachmentsById;
    private CandidatestateEntity candidatestateByIdCandidateState;
    private Collection<CandidatecompetenceEntity> candidatecompetencesById;
    private Collection<CandidateexperienceEntity> candidateexperiencesById;
    private Collection<ContactdetailsEntity> contactdetailsById;
    private Collection<InterviewEntity> interviewsById;
    private Collection<VacancycandidatesEntity> vacancycandidatesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "photoFilePath")
    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

    @Basic
    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "idCandidateState")
    public Integer getIdCandidateState() {
        return idCandidateState;
    }

    public void setIdCandidateState(Integer idCandidateState) {
        this.idCandidateState = idCandidateState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidateEntity that = (CandidateEntity) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (photoFilePath != null ? !photoFilePath.equals(that.photoFilePath) : that.photoFilePath != null)
            return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (idCandidateState != null ? !idCandidateState.equals(that.idCandidateState) : that.idCandidateState != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (photoFilePath != null ? photoFilePath.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (idCandidateState != null ? idCandidateState.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<AttachmentEntity> getAttachmentsById() {
        return attachmentsById;
    }

    public void setAttachmentsById(Collection<AttachmentEntity> attachmentsById) {
        this.attachmentsById = attachmentsById;
    }

    @ManyToOne
    @JoinColumn(name = "idCandidateState", referencedColumnName = "id")
    public CandidatestateEntity getCandidatestateByIdCandidateState() {
        return candidatestateByIdCandidateState;
    }

    public void setCandidatestateByIdCandidateState(CandidatestateEntity candidatestateByIdCandidateState) {
        this.candidatestateByIdCandidateState = candidatestateByIdCandidateState;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<CandidatecompetenceEntity> getCandidatecompetencesById() {
        return candidatecompetencesById;
    }

    public void setCandidatecompetencesById(Collection<CandidatecompetenceEntity> candidatecompetencesById) {
        this.candidatecompetencesById = candidatecompetencesById;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<CandidateexperienceEntity> getCandidateexperiencesById() {
        return candidateexperiencesById;
    }

    public void setCandidateexperiencesById(Collection<CandidateexperienceEntity> candidateexperiencesById) {
        this.candidateexperiencesById = candidateexperiencesById;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<ContactdetailsEntity> getContactdetailsById() {
        return contactdetailsById;
    }

    public void setContactdetailsById(Collection<ContactdetailsEntity> contactdetailsById) {
        this.contactdetailsById = contactdetailsById;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<InterviewEntity> getInterviewsById() {
        return interviewsById;
    }

    public void setInterviewsById(Collection<InterviewEntity> interviewsById) {
        this.interviewsById = interviewsById;
    }

    @OneToMany(mappedBy = "candidateByIdCandidate")
    public Collection<VacancycandidatesEntity> getVacancycandidatesById() {
        return vacancycandidatesById;
    }

    public void setVacancycandidatesById(Collection<VacancycandidatesEntity> vacancycandidatesById) {
        this.vacancycandidatesById = vacancycandidatesById;
    }
}
