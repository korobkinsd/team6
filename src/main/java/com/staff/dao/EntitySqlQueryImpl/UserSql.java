package com.staff.dao.EntitySqlQueryImpl;

import com.staff.api.dao.ISqlQuery;

public class UserSql implements ISqlQuery {
    @Override
    public String getFindByIdSql() {
        return "SELECT * FROM user WHERE id=:id";
    }

    @Override
    public String getFindAllSql() {
        return "SELECT * FROM user";
    }

    @Override
    public String getSaveSql() {
        return "INSERT INTO USER(NAME, EMAIL, SURNAME, PASSWORD) "
                + "VALUES ( :name, :email, :surname, :password)";
    }

    @Override
    public String getUpdateSql() {
        return "UPDATE USER SET NAME=:name, EMAIL=:email, SURNAME=:surname, " + "PASSWORD=:password WHERE id=:id";
    }

    @Override
    public String getDeleteSql() {
        return "DELETE FROM USER WHERE id= :id";
    }
}