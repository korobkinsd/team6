package com.staff.dao;

import com.staff.api.dao.ICrudDao;
import com.staff.api.dao.ISqlQuery;
import com.staff.api.entity.IEntity;
import com.staff.api.enums.Paging;
import com.staff.api.sort.ISort;
import com.staff.api.specification.ISpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import java.util.*;

public abstract class CrudDao<T> implements ICrudDao<T> {

    protected RowMapper<T> rowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    protected ISqlQuery sqlQuery;

    public CrudDao(){}

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    protected RowMapper<T> getRowMapper(){
        return this.rowMapper;
    }

    protected void setRowMapper(RowMapper<T> value){
        this.rowMapper = value;
    }

    protected ISqlQuery getSqlQuery(){
        return this.sqlQuery;
    }

    protected void setSqlQuery(ISqlQuery value){
        this.sqlQuery = value;
    }

    @Override
    public void save(IEntity<T> entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(getSqlQuery().getSaveSql(), getSqlParameterByModel(entity), keyHolder);
        entity.setForeignKey(String.valueOf(keyHolder.getKey().intValue()));
    }

    @Override
    public void update(IEntity<T> entity) {
        namedParameterJdbcTemplate.update(getSqlQuery().getUpdateSql(), getSqlParameterByModel(entity));
    }

    @Override
    public void delete(ISpecification<T> specification) {
        namedParameterJdbcTemplate.update(String.format(getSqlQuery().getDeleteSql(), specification.Builder()), new MapSqlParameterSource());
    }

    @Override
    public List<T> Find(ISpecification<T> specification) {
        List<T> result = namedParameterJdbcTemplate.query(getSqlQuery().getBaseSql(), getRowMapper());

        return result;
    }

    @Override
    public List<T> FindWithPaging(ISpecification<T> specification, ISort sort, int page, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Paging.LIMIT.toString(), pageSize);
        params.put(Paging.OFFSET.toString(), page*pageSize-pageSize);
        return namedParameterJdbcTemplate.query(String.format(getSqlQuery().getFullSql(), specification.Builder(), sort.Builder()), params, rowMapper);
    }

    @Override
    public T Read(ISpecification<T> specification) {

        ISqlQuery sqlQuery = getSqlQuery();
        T result = null;
        try {
            result = namedParameterJdbcTemplate.queryForObject(String.format(sqlQuery.getBaseSql().concat(sqlQuery.getSpecificationSql()), specification.Builder(), ""), new HashMap<String, Object>(), rowMapper);
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return result;
    }

    @Override
    public int Count(ISpecification<T> specification) {

        List<T> result = namedParameterJdbcTemplate.query(getSqlQuery().getBaseSql(), getRowMapper());

        return result.size();
    }

    protected abstract SqlParameterSource getSqlParameterByModel(IEntity<T> entity);

    protected static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    protected String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }
}
