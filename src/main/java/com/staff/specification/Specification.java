package com.staff.specification;

import com.staff.api.specification.ISpecification;

import java.util.ArrayList;
import java.util.List;

public abstract class Specification<T> implements ISpecification<T> {

    private String specification;

    @Override
    public String getSpecification() {
        return specification == null ? " where " : specification;
    }

    protected void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public ISpecification<T> Builder() {
        return this;
    }

    @Override
    public ISpecification<T> And() {
        this.setSpecification(this.getSpecification() + " and ");
        return this;
    }

    protected  <L> void ConcatenationOrList(List<L> list){
        this.setSpecification(this.getSpecification() + " ( ");
        int size = list.size();
        for(int i = 0; i < size; i++) {
            this.Concatenation(list.get(i));
            if(i+1 < size){
                this.setSpecification(this.getSpecification() + " , ");
            }
        }
        this.setSpecification(this.getSpecification() + " ) ");
    }

    protected  <L> void Concatenation(L value){
        String query = " " + this.getSpecification() + value.toString() + " ";
        this.setSpecification(query);
    }
}
