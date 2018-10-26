package com.staff.api.specification;

import com.staff.api.entity.Interview;
import java.util.List;

public interface IInterviewSpecification extends ISpecification<Interview> {

    IInterviewSpecification GetAnd();
    IInterviewSpecification GetById(Integer id);
    IInterviewSpecification GetByIdIn(List<Integer> ids);
    IInterviewSpecification GetByIdVacancy(Integer idVacancy);
    IInterviewSpecification GetByIdCandidate(Integer idCandidate);
    IInterviewSpecification GetByPlanDate(String planDate);
    IInterviewSpecification GetByPlanDateLike(String planDate);
    IInterviewSpecification GetByFactDate(String factDate);
    IInterviewSpecification GetByFactDateLike(String factDate);
}