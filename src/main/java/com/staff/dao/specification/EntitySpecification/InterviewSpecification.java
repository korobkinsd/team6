package com.staff.dao.specification.EntitySpecification;

import com.staff.api.entity.Interview;
import com.staff.api.enums.Sort.SortInterviewFields;
import com.staff.api.specification.IInterviewSpecification;
import com.staff.dao.specification.Specification;

import java.util.List;

public class InterviewSpecification extends Specification<Interview> implements IInterviewSpecification{

    private String GetFilterLike(String value){
        String _like = " like ";
        return _like + " '%" + value + "%' ";
    }

    private String Stub(){
        return this.getSpecification() + " 1 = 1 ";
    }

    @Override
    public IInterviewSpecification GetAnd(){
        this.setSpecification( this.getSpecification() == " where " ? this.getSpecification() : this.getSpecification() + " and "  );
        return this;
    }

    @Override
    public IInterviewSpecification GetById(Integer id) {
        if (id !=null) {
            this.And();
            this.setSpecification(this.getSpecification() + " ".concat(SortInterviewFields.ID.toString()));
            this.ConcatForEquals(id);
        }
        return this;
    }

    @Override
    public IInterviewSpecification GetByIdIn(List<Integer> ids) {
        if(ids != null && ids.size() > 0){
            this.setSpecification(this.getSpecification() + " ".concat(SortInterviewFields.ID.toString()));
            this.ConcatForOr(ids);
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public IInterviewSpecification GetByIdVacancy(Integer idVacancy) {
        if (idVacancy != null ) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("idVacancy"));
            this.ConcatForEquals(idVacancy);
        }
        return this;
    }

    @Override
    public IInterviewSpecification GetByIdCandidate(Integer idCandidate) {
        if (idCandidate != null ) {
            this.And();
            this.setSpecification(this.getSpecification() +" ".concat("idCandidate"));
            this.ConcatForEquals(idCandidate);}
        return this;
    }


    @Override
    public IInterviewSpecification GetByPlanDate(String planDate) {
        return null;
    }

    @Override
    public IInterviewSpecification GetByPlanDateLike(String planDate) {
        if (planDate != null ){
            this.setSpecification(this.getSpecification() + " ".concat(SortInterviewFields.PLANDATE.toString()) + GetFilterLike(planDate));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public IInterviewSpecification GetByFactDate(String factDate) {
        return null;
    }

    @Override
    public IInterviewSpecification GetByFactDateLike(String factDate) {
        if (factDate != null ){
            this.setSpecification(this.getSpecification() + " ".concat(SortInterviewFields.FACTDATE.toString()) + GetFilterLike(factDate));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }
}