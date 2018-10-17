package com.staff.specification.EntityRepository;

import com.staff.api.entity.User;
import com.staff.api.specification.IUserSpecification;
import com.staff.specification.Specification;

import java.util.List;

public class UserSpecification extends Specification<User> implements IUserSpecification{
    @Override
    public IUserSpecification GetById(Integer id) {
        this.setSpecification(this.getSpecification() + " id = ");
        this.Concatenation(id);
        return this;
    }

    @Override
    public IUserSpecification GetByIdIn(List<Integer> ids) {
        return null;
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
