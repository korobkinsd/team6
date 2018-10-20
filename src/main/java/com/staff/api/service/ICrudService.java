package com.staff.api.service;

import com.staff.api.entity.IEntity;
import com.staff.api.sort.ISort;
import com.staff.api.specification.ISpecification;

import java.util.List;

public interface ICrudService<T> {

    void saveOrUpdate(IEntity<T> entity, ISpecification<T> specification);

    void delete(ISpecification<T> specification);

    List<T> Find(ISpecification<T> specification);
    List<T> FindWithPaging(ISpecification<T> specification, ISort sort, int page, int pageSize);

    T Read(ISpecification<T> specification);
    int Count(ISpecification<T> specification);
}
