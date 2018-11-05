package com.staff.dao.specification.EntitySpecification;

import com.staff.api.Utils.DataConverter;
import com.staff.api.entity.Candidate;
import com.staff.api.enums.Sort.SortCandidateFields;
import com.staff.api.specification.ICandidateSpecification;
import com.staff.dao.specification.Specification;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

public class CandidateSpecification extends Specification<Candidate> implements ICandidateSpecification {

    private String GetFilterLike(String value){
        String _like = " like ";
        return _like + " '%" + value + "%' ";
    }

    private String Stub(){
        return this.getSpecification() + " 1 = 1 ";
    }

    @Override
    public ICandidateSpecification GetAnd(){
        this.setSpecification(  this.getSpecification() == " where " ? this.getSpecification() : this.getSpecification() + " and "  );
        return this;
    }

    @Override
    public ICandidateSpecification GetById(String id) {
        this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.ID.toString()));
        this.ConcatForEquals(id);
        return this;
    }

    @Override
    public ICandidateSpecification GetByIdIn(List<Integer> ids) {
        if(ids != null && ids.size() > 0){
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.ID.toString()));
            this.ConcatForOr(ids);
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public ICandidateSpecification GetByName(String name) {
        if (name != null && !name.isEmpty()) {
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.NAME.toString()));
            this.ConcatForEquals(name);
        } else {
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public ICandidateSpecification GetByNameLike(String name) {
        if (name != null && !name.isEmpty()){
            this.setSpecification(this.getSpecification() + " UPPER(".concat(SortCandidateFields.NAME.toString()).concat(")") + GetFilterLike(name.toUpperCase()));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public ICandidateSpecification GetBySurname(String surname) {
        this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.SURNAME.toString()));
        this.ConcatForEquals(surname);
        return this;
    }

    @Override
    public ICandidateSpecification GetBySurnameLike(String surname) {
        if (surname != null && !surname.isEmpty()){
            this.setSpecification(this.getSpecification() + " UPPER(".concat(SortCandidateFields.SURNAME.toString()).concat(")") + GetFilterLike(surname.toUpperCase()));
        }else{
            this.setSpecification(this.Stub());
        }
        //this.setSpecification(this.getSpecification() + " UPPER(".concat(SortCandidateFields.SURNAME.toString()).concat(")"));
        //this.ConcatForLike(surname.toUpperCase());
        return this;
    }

    @Override
    public ICandidateSpecification GetBySalary(Double salaryFrom, Double salaryTo) {
        if (salaryFrom > 0) {
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.SALARY.toString()));
            this.ConcatForGreaterThan(salaryFrom.toString());
        } else {
            this.setSpecification(this.Stub());
        }

        if (salaryTo > 0) {
            this.And();
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.SALARY.toString()));
            this.ConcatForLessThan(salaryTo.toString());
        } else {
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public ICandidateSpecification GetByBirthday(String birthdayFrom, String birthdayTo) {

        if (birthdayFrom != null && !birthdayFrom.isEmpty()){
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.BIRTHDAY.toString()) );
            this.ConcatForGreaterThan(birthdayFrom);
        }else{
            this.setSpecification(this.Stub());
        }
        if (birthdayTo != null && !birthdayTo.isEmpty()){
            this.And();
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.BIRTHDAY.toString()) );
            this.ConcatForLessThan(birthdayTo);
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }
}

