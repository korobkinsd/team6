package com.staff.api.entity;

import com.staff.api.utils.DataConverter;

import java.sql.Date;
import java.util.List;
/*
* Filter for searching candidates
*/

public class CandidateFilter {
    private String name;

    private String surname;

    private Date birthdayFrom;

    private Date birthdayTo;

    private Double salaryFrom;

    private Double salaryTo;

    private List<Candidate.CandidateState> candidateStates;


    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(String surname) {
        this.surname = surname;
    }

    public final void setBirthdayFrom(String birthdayFrom) {
        this.birthdayFrom = DataConverter.toDate(birthdayFrom);
    }

    public final Date getBirthdayFrom() {
        return birthdayFrom;
    }

    public final String getBirthdayFromAsString() {
        return DataConverter.toStr(birthdayFrom);
    }

    public final void setBirthdayTo(String birthdayTo) {
        this.birthdayTo = DataConverter.toDate(birthdayTo);
    }

    public final Date getBirthdayTo() {
        return birthdayTo;
    }

    public final String getBirthdayToAsString() {
        return DataConverter.toStr(this.birthdayTo);
    }

    public final Double getSalaryFrom() {
        return salaryFrom;
    }

    public final void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public final Double getSalaryTo() {
        return salaryTo;
    }

    public final void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    public final List<Candidate.CandidateState> getCandidateStates() {
        return candidateStates;
    }

    public final void setCandidateStates(List<Candidate.CandidateState> candidateStates) {
        this.candidateStates = candidateStates;
    }

    @Override
    public final String toString() {
        return "CandidateFilter{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdayFrom=" + birthdayFrom +
                ", birthdayTo=" + birthdayTo +
                ", salaryFrom=" + salaryFrom +
                ", salaryTo=" + salaryTo +
                ", candidateStates=" + candidateStates +
                '}';
    }
}
