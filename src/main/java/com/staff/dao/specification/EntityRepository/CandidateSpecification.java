package com.staff.dao.specification.EntityRepository;

import com.staff.api.entity.Candidate;
import com.staff.api.enums.Sort.SortCandidateFields;
import com.staff.api.specification.ICandidateSpecification;
import com.staff.dao.specification.Specification;
import java.util.List;

public class CandidateSpecification extends Specification<Candidate> implements ICandidateSpecification {
    @Override
    public ICandidateSpecification GetById(String id) {
        this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.ID.toString()));
        this.ConcatForEquals(id);
        return this;
    }

    @Override
    public ICandidateSpecification GetByIdIn(List<Integer> ids) {
        this.setSpecification(" ".concat(SortCandidateFields.ID.toString()));
        this.ConcatForOr(ids);
        return this;
    }

    @Override
    public ICandidateSpecification GetByName(String name) {
        this.setSpecification(this.getSpecification() + " ".concat(SortCandidateFields.NAME.toString()));
        this.ConcatForEquals(name);
        return this;
    }

    @Override
    public ICandidateSpecification GetByNameLike(String name) {
        this.setSpecification(this.getSpecification() + " UPPER(".concat(SortCandidateFields.NAME.toString()).concat(")"));
        this.ConcatForLike(name.toUpperCase());
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
        this.setSpecification(this.getSpecification() + " UPPER(".concat(SortCandidateFields.SURNAME.toString()).concat(")"));
        this.ConcatForLike(surname.toUpperCase());
        return this;
    }
}

