package com.staff.api.entity;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
/*
* Filter for searching canodates
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

    public Date getBirthdayFrom() {
        return birthdayFrom;
    }

    public final String getBirthdayFromAsString() {
        if (!(this.birthdayFrom == null)) {
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(birthdayFrom);
        } else {
            return "";
        }
    }

    public void setBirthdayFrom(Date birthdayFrom) {
        this.birthdayFrom = birthdayFrom;
    }

    public Date getBirthdayTo() {
        return birthdayTo;
    }

    public final String getBirthdayToAsString() {
        if (!(this.birthdayTo == null)) {
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(birthdayTo);
        } else {
            return "";
        }
    }

    public void setBirthdayTo(Date birthdayTo) {
        this.birthdayTo = birthdayTo;
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
