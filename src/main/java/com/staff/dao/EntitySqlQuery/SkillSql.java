package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class SkillSql implements ISqlQuery{

    @Override
    public String getBaseSql() {
        return "SELECT NAME FROM SKILL";
    }

    @Override
    public String getSaveSql() {
        return "INSERT INTO SKILL(NAME) "
                + "VALUES ( :name)";
    }

    @Override
    public String getUpdateSql() {
        return "UPDATE USER SET NAME=:name  WHERE NAME=:name";
    }

    @Override
    public String getDeleteSql() {
        return "DELETE FROM SKILL %s ";
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
