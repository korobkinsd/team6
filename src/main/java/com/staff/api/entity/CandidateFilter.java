package com.staff.api.entity;

import com.staff.api.Utils.DataConverter;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdayFrom(String birthdayFrom) {
        this.birthdayFrom = DataConverter.toDate(birthdayFrom);
    }

    public Date getBirthdayFrom() {
        return birthdayFrom;
    }

    public final String getBirthdayFromAsString() {
        return DataConverter.toStr(birthdayFrom);
    }

    public void setBirthdayTo(String birthdayTo) {
        this.birthdayTo = DataConverter.toDate(birthdayTo);
    }

    public Date getBirthdayTo() {
        return birthdayTo;
    }

    public final String getBirthdayToAsString() {
        return DataConverter.toStr(this.birthdayTo);
    }

    public Double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    public List<Candidate.CandidateState> getCandidateStates() {
        return candidateStates;
    }

    public void setCandidateStates(List<Candidate.CandidateState> candidateStates) {
        this.candidateStates = candidateStates;
    }

    @Override
    public String toString() {
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
