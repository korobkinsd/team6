package com.staff.api.specification;

import com.staff.api.entity.User;

import java.util.List;

public interface IUserSpecification extends ISpecification<User> {

    IUserSpecification GetById(Integer id);

    IUserSpecification GetByIdIn(List<Integer> ids);

    IUserSpecification GetByName(String name);

    IUserSpecification GetByNameLike(String name);

    IUserSpecification GetByEmail(String email);

    IUserSpecification GetBySurname(String surname);

    IUserSpecification GetBySurnameLike(String surname);
}
