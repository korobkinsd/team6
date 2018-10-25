package com.staff.dao.EntityDao;

import com.staff.api.dao.ISkillDao;
import com.staff.api.entity.IEntity;
import com.staff.api.entity.Skill;
import com.staff.dao.EntitySqlQuery.SkillSql;
import com.staff.dao.CrudDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SkillDao extends CrudDao<Skill> implements ISkillDao {

    public SkillDao(){
        super();
        this.setRowMapper(new SkillMapper());
        this.setSqlQuery(new SkillSql());
    }

    @Override
    protected SqlParameterSource getSqlParameterByModel(IEntity<Skill> entity) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
        Skill skill = (Skill)entity;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("name", skill.getSkill());

        return paramSource;
    }

    protected static final class SkillMapper implements RowMapper<Skill> {

        @Override
        public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
            Skill skill = new Skill();
            skill.setSkill(rs.getString("name"));
            return skill;
        }
    }
}
