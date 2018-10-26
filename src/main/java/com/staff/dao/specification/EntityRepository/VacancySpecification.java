
package com.staff.dao.specification.EntityRepository;


import com.staff.api.entity.Vacancy;

import com.staff.api.enums.Sort.SortVacancyFields;

import com.staff.api.specification.IVacancySpecification;
import com.staff.dao.specification.Specification;


import java.util.List;

public class VacancySpecification extends Specification<Vacancy> implements IVacancySpecification {
    @Override
    public IVacancySpecification GetById(Integer id) {
        if (id !=null) {
            this.And();
            this.setSpecification(this.getSpecification() + " ".concat(SortVacancyFields.ID.toString()));
            this.ConcatForEquals(id);
        }
        return this;
    }

    @Override
    public IVacancySpecification GetByIdIn(List<Integer> ids) {
        this.setSpecification(this.getSpecification() +" ".concat(SortVacancyFields.ID.toString()));
        this.ConcatForOr(ids);
        return this;
    }

    @Override
    public IVacancySpecification GetByPosition(String position) {
        if (position !="" & position !=null) {
         this.And();
        this.setSpecification(this.getSpecification() +" ".concat(SortVacancyFields.POSITION.toString()));
        this.ConcatForEquals(position);}
        return this;
    }

    @Override
    public IVacancySpecification GetByPositionLike( String position) {
        if (position !="" & position !=null) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat(SortVacancyFields.POSITION.toString()));
            this.ConcatForLike(position);
        }
        return this;
    }

    @Override
    public IVacancySpecification GetByIdDeveloper(Integer idDeveloper) {
        if (idDeveloper !=null & idDeveloper!=0) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("iddeveloper"));
            this.ConcatForEquals(idDeveloper);}
        return this;
    }

    @Override
    public IVacancySpecification GetBySalaryTo(Double SalaryTo) {
        if (SalaryTo !=null & SalaryTo!=0) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("SalaryTo"));
            this.ConcatForEquals(SalaryTo);}
        return this;
    }

    @Override
    public IVacancySpecification GetBySalaryFrom(Double SalaryFrom) {
        if (SalaryFrom !=null & SalaryFrom!=0) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("SalaryFrom"));
            this.ConcatForEquals(SalaryFrom);}
        return this;
    }
    @Override
    public IVacancySpecification GetByExperienceYearsRequire(Double experienceYearsRequire) {
        if (experienceYearsRequire !=null & experienceYearsRequire!=0) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("experienceYearsRequire"));
            this.ConcatForEquals(experienceYearsRequire);}
        return this;
    }
    @Override
    public IVacancySpecification GetByState(String state) {
        if (state !=null &  state !="" ) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("vacancyState"));
            this.ConcatForEquals(state);}
        return this;
    }
}

