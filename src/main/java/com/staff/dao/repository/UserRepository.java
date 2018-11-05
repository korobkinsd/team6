package com.staff.dao.repository;

import com.staff.api.entity.User;
import com.staff.api.repository.IUserRepository;
import com.staff.dao.EntitySqlQuery.UserSql;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepository extends CrudRepository<User> implements IUserRepository{

    @Autowired
    public UserRepository(UserSql userSql){
        this.sqlQuery = userSql;
    }
}
