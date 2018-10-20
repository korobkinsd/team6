package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class SkillSql implements ISqlQuery{

    @Override
    public String getBaseSql() {
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

    @Override
    public String getFullSql() {
        return this.getBaseSql().concat(this.getSpecificationSql()).concat(this.getSortSql()).concat(this.getPagingSql());
    }

    @Override
    public String getSpecificationSql() {
        return null;
    }

    @Override
    public String getSortSql() {
        return null;
    }

    @Override
    public String getPagingSql() {
        return null;
    }


}
