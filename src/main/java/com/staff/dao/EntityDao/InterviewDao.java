package com.staff.dao.EntityDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.staff.api.dao.IInterviewDao;
import com.staff.api.entity.IEntity;
import com.staff.api.entity.Interview;
import com.staff.dao.CrudDao;
import com.staff.dao.EntitySqlQuery.InterviewSql;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDao extends CrudDao<Interview> implements IInterviewDao {

    public InterviewDao(){
        super();
        this.setRowMapper(new InterviewMapper());
        this.setSqlQuery(new InterviewSql());
    }

    @Override
    protected SqlParameterSource getSqlParameterByModel(IEntity<Interview> entity) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
        Interview interview = (Interview) entity;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", interview.getId());
        paramSource.addValue("idVacancy", interview.getIdVacancy());
        paramSource.addValue("idCandidate", interview.getIdCandidate());
        paramSource.addValue("planDate", interview.getPlanDate());
        paramSource.addValue("factDate", interview.getFactDate());

        return paramSource;
    }

    protected static final class InterviewMapper implements RowMapper<Interview> {

        @Override
        public Interview mapRow(ResultSet rs, int rowNum) throws SQLException {
            Interview interview = new Interview();
            interview.setId(rs.getInt("id"));
            interview.setIdVacancy(rs.getInt("idVacancy"));
            interview.setIdCandidate(rs.getInt("idCandidate"));
            interview.setPlanDate( rs.getDate("planDate"));
            interview.setFactDate( rs.getDate("factDate"));

            return interview;
        }
    }
}