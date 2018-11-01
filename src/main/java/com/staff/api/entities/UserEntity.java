package com.staff.api.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "team6", catalog = "")
public class UserEntity {
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private byte isBlocked;
    private Collection<InterviewfeedbackEntity> interviewfeedbacksById;
    private Collection<UserrolesEntity> userrolesById;
    private Collection<VacancyEntity> vacanciesById;

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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "isBlocked")
    public byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (isBlocked != that.isBlocked) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (int) isBlocked;
        return result;
    }

    @OneToMany(mappedBy = "userByIdInterviewer")
    public Collection<InterviewfeedbackEntity> getInterviewfeedbacksById() {
        return interviewfeedbacksById;
    }

    public void setInterviewfeedbacksById(Collection<InterviewfeedbackEntity> interviewfeedbacksById) {
        this.interviewfeedbacksById = interviewfeedbacksById;
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<UserrolesEntity> getUserrolesById() {
        return userrolesById;
    }

    public void setUserrolesById(Collection<UserrolesEntity> userrolesById) {
        this.userrolesById = userrolesById;
    }

    @OneToMany(mappedBy = "userByIdDeveloper")
    public Collection<VacancyEntity> getVacanciesById() {
        return vacanciesById;
    }

    public void setVacanciesById(Collection<VacancyEntity> vacanciesById) {
        this.vacanciesById = vacanciesById;
    }
}
