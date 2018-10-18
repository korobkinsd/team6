package com.staff.api.specification;

public interface ISpecification<T> {
    String getSpecification();

    String Builder();

    ISpecification<T> And();
}
