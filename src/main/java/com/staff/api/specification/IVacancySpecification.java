
package com.staff.api.specification;


import com.staff.api.entity.Vacancy;

import java.util.List;


public interface IVacancySpecification extends ISpecification<Vacancy> {

    IVacancySpecification GetById(Integer id);

    IVacancySpecification GetByIdIn(List<Integer> ids);

    IVacancySpecification GetByPosition(String position);

    IVacancySpecification GetByPositionLike(String position);

    IVacancySpecification GetByIdDeveloper(Integer idDeveloper);

     IVacancySpecification GetBySalaryTo(Double SalaryTo) ;
     IVacancySpecification GetBySalaryFrom(Double SalaryFrom) ;

    IVacancySpecification GetByExperienceYearsRequire(Double experienceYearsRequire);
    IVacancySpecification GetByState(String state);
}

