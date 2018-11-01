/*
package com.staff.dao.repository;

import com.staff.api.entity.IEntity;
import com.staff.api.repository.ICrudRepository;
import com.staff.api.sort.ISort;
import com.staff.api.specification.ISpecification;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class CrudRepository implements ICrudRepository {

    private final SessionFactory factory;

    @Autowired
    public CrudRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(IEntity entity) {

    }

    @Override
    public void update(IEntity entity) {

    }

    @Override
    public void delete(ISpecification specification) {

    }

    @Override
    public List Find(ISpecification specification) {
        return null;
    }

    @Override
    public List FindWithPaging(ISpecification specification, ISort sort, int page, int pageSize) {
        return null;
    }

    @Override
    public Object Read(ISpecification specification) {
        return null;
    }

    @Override
    public int Count(ISpecification specification) {
        return 0;
    }
}
*/
