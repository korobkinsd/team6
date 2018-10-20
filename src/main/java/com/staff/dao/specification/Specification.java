package com.staff.dao.specification;

import com.staff.api.specification.ISpecification;
import java.util.Iterator;
import java.util.List;

public abstract class Specification<T> implements ISpecification<T> {

    private String specification = "";
    private String whereStr = " where ";

    @Override
    public String getSpecification() {
        return specification == "" ? whereStr : specification;
    }

    protected void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String Builder() {
        return this.getSpecification() == whereStr ? "" : getSpecification();
    }

    @Override
    public ISpecification<T> And() {
        this.setSpecification(this.getSpecification() + " and ");
        return this;
    }

    protected <L> void ConcatForOr(List<L> list){
        StringBuilder valueString  = new StringBuilder();
        Iterator<L> iterator = list.iterator();
        while(iterator.hasNext())
        {
            valueString.append(iterator.next());
            if(iterator.hasNext()){
                valueString.append(", ");
            }
        }
        this.WrapForOperationIn(valueString.toString());
    }

    protected void WrapForOperationIn(String valueString){
        this.setSpecification(this.getSpecification() + " in ( " + valueString + " ) ");
    }

    protected  <L> void ConcatForEquals(L value){
        String query = this.getSpecification() + " = " + value.toString() + " ";
        this.setSpecification(query);
    }
}
