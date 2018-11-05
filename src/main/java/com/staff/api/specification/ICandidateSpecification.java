package com.staff.api.specification;

import com.staff.api.entity.Candidate;
import java.util.List;

public interface ICandidateSpecification extends ISpecification<Candidate> {

    ICandidateSpecification GetAnd();

    ICandidateSpecification GetById(String id);

    ICandidateSpecification GetByIdIn(List<Integer> ids);

    ICandidateSpecification GetByName(String name);

    ICandidateSpecification GetByNameLike(String name);

    ICandidateSpecification GetBySurname(String surname);

    ICandidateSpecification GetBySurnameLike(String surname);

    ICandidateSpecification GetBySalary(Double salaryFrom, Double salaryTo);

    ICandidateSpecification GetByBirthday(String birthdayFrom, String birthdayTo);



}

