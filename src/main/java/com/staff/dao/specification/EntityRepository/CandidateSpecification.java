package com.staff.dao.specification.EntityRepository;

import com.staff.api.entity.Candidate;
import com.staff.api.enums.Sort.SortCandidateFields;
import com.staff.api.specification.ICandidateSpecification;
import com.staff.dao.specification.Specification;

import java.sql.Date;
import java.util.List;

public class CandidateSpecification extends Specification<Candidate> implements ICandidateSpecification {

    private final String _like = " like ";

    private String GetFilterLike(String value){
        return this._like + " '%" + value + "%' ";
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
    public ICandidateSpecification GetBySalary(Double salary) {
        if (salary > 0) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat(SortCandidateFields.SALARY.toString()));
            this.ConcatForEquals(salary);
        } else {
            this.setSpecification(this.Stub());
        }

        return this;
    }

    @Override
    public ICandidateSpecification GetByBirthday(String birthday) {
        if (birthday != null && !birthday.isEmpty()){
            this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.BIRTHDAY.toString()) );
            this.ConcatForEquals(birthday);
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }
}

