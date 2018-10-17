package com.staff.api.dao;

import com.staff.api.entity.IEntity;
import com.staff.api.sort.ISort;
import com.staff.api.specification.ISpecification;

import java.util.List;

public interface IGrudDao<T> {
    T findById(Integer id);

    List<T> findAll();

    void save(IEntity<T> entity);

    void update(IEntity<T> entity);

    void delete(Integer id);

    List<T> Find(ISpecification<T> specification);
    List<T> FindWithPaging(ISpecification<T> specification, ISort sort, int page, int pageSize);

    T Read(ISpecification<T> specification);
    int Count(ISpecification<T> specification);
}