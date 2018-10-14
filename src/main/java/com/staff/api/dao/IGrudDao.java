package com.staff.api.dao;

import com.staff.api.entity.IEntity;

import java.util.List;

public interface IGrudDao<T> {
    T findById(Integer id);

    List<T> findAll();

    void save(IEntity<T> entity);

    void update(IEntity<T> entity);

    void delete(Integer id);
}
