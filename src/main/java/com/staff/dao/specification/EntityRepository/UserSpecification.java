package com.staff.dao.specification.EntityRepository;

import com.staff.api.entity.User;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.specification.IUserSpecification;
import com.staff.dao.specification.Specification;

import java.util.List;

public class UserSpecification extends Specification<User> implements IUserSpecification{
    @Override
    public IUserSpecification GetById(String id) {
        this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.ID.toString()));
        this.ConcatForEquals(id);
        return this;
    }

    @Override
    public IUserSpecification GetByIdIn(List<Integer> ids) {
        this.setSpecification(" ".concat(SortUserFields.ID.toString()));
        this.ConcatForOr(ids);
        return this;
    }

    @Override
    public IUserSpecification GetByName(String name) {
        return null;
    }

    @Override
    public IUserSpecification GetByNameLike(String name) {
        return null;
    }

    @Override
    public IUserSpecification GetByEmail(String email) {
        return null;
    }

    @Override
    public IUserSpecification GetBySurname(String surname) {
        return null;
    }

    @Override
    public IUserSpecification GetBySurnameLike(String surname) {
        return null;
    }
}
