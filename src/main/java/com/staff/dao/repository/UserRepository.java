package com.staff.dao.repository;

import com.staff.api.dao.ISqlQuery;
import com.staff.api.entity.User;
import com.staff.api.repository.IUserRepository;
import com.staff.dao.EntitySqlQuery.UserSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class UserRepository extends CrudRepository<User> implements IUserRepository{

    @Autowired
    public UserRepository(UserSql userSql){
        super();
        this.sqlQuery = userSql;
    }
}
