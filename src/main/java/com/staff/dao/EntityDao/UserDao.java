package com.staff.dao.EntityDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.staff.api.dao.IUserDao;
import com.staff.api.entity.IEntity;
import com.staff.api.entity.User;
import com.staff.dao.CrudDao;
import com.staff.dao.EntitySqlQuery.UserSql;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends CrudDao<User> implements IUserDao {

	public UserDao(){
		super();
		this.setRowMapper(new UserMapper());
		this.setSqlQuery(new UserSql());
	}

	@Override
	protected SqlParameterSource getSqlParameterByModel(IEntity<User> entity) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource
        User user = (User)entity;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", user.getId());
		paramSource.addValue("name", user.getName());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("surname", user.getSurname());
		paramSource.addValue("password", user.getPassword());

		return paramSource;
	}

	protected static final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setSurname(rs.getString("surname"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}
}