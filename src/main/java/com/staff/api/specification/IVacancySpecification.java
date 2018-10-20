package com.staff.api.specification;


import com.staff.api.entity.Vacancy;

import java.util.List;


public interface IVacancySpecification extends ISpecification<Vacancy> {

    IVacancySpecification GetById(Integer id);

    IVacancySpecification GetByIdIn(List<Integer> ids);

    IVacancySpecification GetByName(String name);

    IVacancySpecification GetByNameLike(String name);

    IVacancySpecification GetByEmail(String email);

    IVacancySpecification GetBySurname(String surname);

    IVacancySpecification GetBySurnameLike(String surname);
}
