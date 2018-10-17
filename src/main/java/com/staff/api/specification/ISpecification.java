package com.staff.api.specification;

public interface ISpecification<T> {
    String getSpecification();

    ISpecification<T> Builder();

    ISpecification<T> And();
}
