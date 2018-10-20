package com.staff.specification.EntityRepository;

import com.staff.api.entity.User;
import com.staff.api.entity.Vacancy;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.enums.Sort.SortVacancyFields;
import com.staff.api.specification.IUserSpecification;
import com.staff.api.specification.IVacancySpecification;
import com.staff.specification.Specification;

import java.util.List;

public class VacancySpecification extends Specification<Vacancy> implements IVacancySpecification {
    @Override
    public IVacancySpecification GetById(Integer id) {
        this.setSpecification(this.getSpecification() + " ".concat(SortVacancyFields.ID.toString()));
        this.ConcatForEquals(id);
        return this;
    }

    @Override
    public IVacancySpecification GetByIdIn(List<Integer> ids) {
        this.setSpecification(" ".concat(SortVacancyFields.ID.toString()));
        this.ConcatForOrListInt(ids);
        return this;
    }

    @Override
    public IVacancySpecification GetByName(String name) {
        return null;
    }

    @Override
    public IVacancySpecification GetByNameLike(String name) {
        return null;
    }

    @Override
    public IVacancySpecification GetByEmail(String email) {
        return null;
    }

    @Override
    public IVacancySpecification GetBySurname(String surname) {
        return null;
    }

    @Override
    public IVacancySpecification GetBySurnameLike(String surname) {
        return null;
    }
}
