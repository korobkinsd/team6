package com.staff.dao.EntityDaoImpl;

import com.staff.api.dao.ISkillDao;
import com.staff.api.entity.IEntity;
import com.staff.api.entity.Skill;
import com.staff.dao.EntitySqlQueryImpl.SkillSql;
import com.staff.dao.GrudDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDao extends GrudDao<Skill> implements ISkillDao {

    public SkillDao(){
        super();
        this.setRowMapper(new SkillDao.SkillMapper());
        this.setSqlQuery(new SkillSql());
    }

    @Override
    protected SqlParameterSource getSqlParameterByModel(IEntity<Skill> entity) {

        // Unable to handle List<String> or Array
        // BeanPropertySqlParameterSource
        Skill Skill = (Skill)entity;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("name", Skill.getSkill());

        return paramSource;
    }

    protected static final class SkillMapper implements RowMapper<Skill> {

        @Override
        public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
            Skill Skill = new Skill();
            Skill.setSkill(rs.getString("name"));
            return Skill;
        }
    }
}
