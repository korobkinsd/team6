package com.staff.api.specification;

import com.staff.api.entity.Candidate;

import java.sql.Date;
import java.util.List;

public interface ICandidateSpecification extends ISpecification<Candidate> {

    ICandidateSpecification GetAnd();

    ICandidateSpecification GetById(String id);

    ICandidateSpecification GetByIdIn(List<Integer> ids);

    ICandidateSpecification GetByName(String name);

    ICandidateSpecification GetByNameLike(String name);

    ICandidateSpecification GetBySurname(String surname);

    ICandidateSpecification GetBySurnameLike(String surname);

    ICandidateSpecification GetBySalary(Double salary);

    ICandidateSpecification GetByBirthday(String birthday);



}

