package com.staff.dao.EntitySqlQueryImpl;

import com.staff.api.dao.ISqlQuery;

public class UserSql implements ISqlQuery {
    @Override
    public String getBaseSql() {
        return "SELECT * FROM user";
    }

    @Override
    public String getFindByIdSql() {
        return this.getBaseSql().concat(" WHERE id=:id");
    }

    @Override
    public String getFindAllSql() {
        return this.getBaseSql();
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

    @Override
    public String getCompositeSql() {
        /*%1$s - для WHERE, %2$s - для ORDER BY*/
        return this.getFindAllSql().concat(this.getSpecificationSql()).concat(this.getSortSql()).concat(this.getPagingSql());
    }

    @Override
    public String getSpecificationSql() {
        return " %1$s ";
    }

    @Override
    public String getSortSql() {
        return " %2$s ";
    }

    @Override
    public String getPagingSql() {
        return " LIMIT :LIMIT OFFSET :OFFSET ";
    }
}
