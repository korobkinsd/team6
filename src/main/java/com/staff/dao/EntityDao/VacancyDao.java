
package com.staff.dao.EntityDao;


import com.staff.api.dao.IVacancyDao;
import com.staff.api.entity.IEntity;


import com.staff.api.entity.Vacancy;
import com.staff.dao.EntitySqlQuery.VacancySql;
import com.staff.dao.CrudDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class VacancyDao extends CrudDao<Vacancy> implements IVacancyDao {

    public VacancyDao(){
        super();
        this.setRowMapper(new VacancyMapper());
        this.setSqlQuery(new VacancySql());
    }

    @Override
    protected SqlParameterSource getSqlParameterByModel(IEntity<Vacancy> entity) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
        Vacancy vacancy = (Vacancy)entity;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", vacancy.getId());
        paramSource.addValue("position", vacancy.getPosition());
        paramSource.addValue("iddeveloper", vacancy.getIdDeveloper());
        paramSource.addValue("salaryfrom", vacancy.getSalaryFrom());
        paramSource.addValue("salaryto", vacancy.getSalaryTo());
        paramSource.addValue("experienceyearsrequire", vacancy.getExperienceYearsRequire());
        paramSource.addValue("vacancyState", vacancy.getState());

        return paramSource;
    }

    protected static final class VacancyMapper implements RowMapper<Vacancy> {

        @Override
        public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
            Vacancy vacancy = new Vacancy();
            vacancy.setId(rs.getInt("id"));
            vacancy.setPosition(rs.getString("position"));
            vacancy.setIdDeveloper(rs.getInt("iddeveloper"));
            vacancy.setSalaryFrom(rs.getDouble("salaryfrom"));
            vacancy.setSalaryTo(rs.getDouble("salaryto"));
            vacancy.setExperienceYearsRequire(rs.getDouble("experienceyearsrequire"));
            vacancy.setState(rs.getString("vacancyState"));
            return vacancy;
        }
    }
}
