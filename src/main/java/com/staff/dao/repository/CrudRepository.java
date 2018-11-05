package com.staff.dao.repository;

import com.staff.api.dao.ISqlQuery;
import com.staff.api.entity.IEntity;
import com.staff.api.repository.ICrudRepository;
import com.staff.api.sort.ISort;
import com.staff.api.specification.ISpecification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public abstract class CrudRepository<T> implements ICrudRepository<T> {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CrudRepository.class);

    private SessionFactory sessionFactory;

    protected ISqlQuery sqlQuery;

    //@Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(IEntity<T> entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(entity);
        logger.info("Сущность успешно сохранена: " + entity);
    }

    @Override
    public void update(IEntity<T> entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("Сущность успешно обновлена: " + entity);
    }

    @Override
    public void delete(ISpecification specification) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = sqlQuery.getDeleteSql().concat(specification.Builder());
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        logger.info("Rows affected: " + result);
    }

    @Override
    public List<T> Find(ISpecification specification, ISort sort) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = String.format(sqlQuery.getBaseSql().concat(
                sqlQuery.getSpecificationSql()).concat(sqlQuery.getSortSql()),
                specification.Builder(), sort.Builder());
        Query query = session.createQuery(hql);
        List<T> results = query.list();
        return results;
    }

    @Override
    public List<T> FindWithPaging(ISpecification specification, ISort sort, int page, int pageSize) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = String.format(sqlQuery.getBaseSql().concat(
                sqlQuery.getSpecificationSql()).concat(sqlQuery.getSortSql()),
                specification.Builder(), sort.Builder());
        Query query = session.createQuery(hql);
        query.setFirstResult(page);
        query.setMaxResults(pageSize);
        List results = query.list();
        return results;
    }

    @Override
    public T Read(ISpecification specification) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = sqlQuery.getDeleteSql().concat(specification.Builder());
        Query query = session.createQuery(hql);
        List<T> results = query.list();
        //TODO: не знаю как правильно сделать, ведь метод должен возвращать только один объект
        //TODO: как правильно обработать возвращение нелькольких объектов
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public int Count(ISpecification specification) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = String.format(sqlQuery.getCountSpl(), specification.Builder());
        Query query = session.createQuery(hql);
        return ((Number) query.uniqueResult()).intValue();
    }
}
