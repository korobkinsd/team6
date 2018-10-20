package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class UserSql implements ISqlQuery {
    @Override
    public String getBaseSql() {
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
        return "DELETE FROM USER %s ";
    }

    @Override
    public String getFullSql() {
        return this.getBaseSql().concat(this.getSpecificationSql()).concat(this.getSortSql()).concat(this.getPagingSql());
    }

    @Override
    public String getSpecificationSql() {
        return " %s ";
    }

    @Override
    public String getSortSql() {
        return " %s ";
    }

    @Override
    public String getPagingSql() {
        return " LIMIT :LIMIT OFFSET :OFFSET ";
    }
}
