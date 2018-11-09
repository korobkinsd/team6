//package com.staff.dao.EntityDao;
//
//import com.staff.api.dao.ICandidateDao;
//import com.staff.api.entity.IEntity;
//import com.staff.api.entity.Candidate;
//import com.staff.dao.CrudDao;
//import com.staff.dao.EntitySqlQuery.CandidateSql;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class CandidateDao extends CrudDao<Candidate> implements ICandidateDao {
//
//    public CandidateDao(){
//        super();
//        this.setRowMapper(new CandidateMapper());
//        this.setSqlQuery(new CandidateSql());
//    }
//
//    @Override
//    protected SqlParameterSource getSqlParameterByModel(IEntity<Candidate> entity) {
//
//        // Unable to handle List<String> or Array
//        // BeanPropertySqlParameterSource
//        Candidate candidate = (Candidate)entity;
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id", candidate.getId());
//        paramSource.addValue("name", candidate.getName());
//        paramSource.addValue("salary", candidate.getSalary());
//        paramSource.addValue("surname", candidate.getSurname());
//        paramSource.addValue("birthday", candidate.getBirthday());
//        paramSource.addValue( "candidateState", candidate.getCandidateState().getDescription());
//        return paramSource;
//    }
//
//    static final class CandidateMapper implements RowMapper<Candidate> {
//
//        @Override
//        public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Candidate candidate = new Candidate();
//            candidate.setId(rs.getInt("id"));
//            candidate.setName(rs.getString("name"));
//            candidate.setSalary(rs.getDouble("salary"));
//            candidate.setSurname(rs.getString("surname"));
//            candidate.setBirthday(rs.getString("birthday"));
//            candidate.setCandidateState( rs.getString("candidateState") );
//            return candidate;
//        }
//    }
//}