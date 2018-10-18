package com.staff.dao.EntitySqlQueryImpl;

import com.staff.api.dao.ISqlQuery;

public class SkillSql implements ISqlQuery{

    @Override
    public String getFindByIdSql() {
        return "SELECT * FROM skill WHERE name=:name";
    }

    @Override
    public String getFindAllSql() {
        return "SELECT * FROM skill";
    }

    @Override
    public String getSaveSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }

    @Override
    public String getDeleteSql() {
        return null;
    }


}
