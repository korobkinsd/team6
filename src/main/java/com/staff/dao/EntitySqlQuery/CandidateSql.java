package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class CandidateSql implements ISqlQuery {

    @Override
    public String getBaseSql() {
        return "SELECT * FROM candidate";
    }

    @Override
    public String getSaveSql() {
        return "INSERT INTO candidate(`name`, `surname`, `birthday`, `salary`, `candidateState`) "
                + "VALUES ( :name, :surname, :birthday, :salary, :candidateState)";
    }

    @Override
    public String getUpdateSql() {
        return "UPDATE candidate SET `name`=:name, `surname`=:surname, `birthday`=:birthday, `salary`=:salary, `candidateState`=:candidateState WHERE `id`=:id";
    }

    @Override
    public String getDeleteSql() {
        return "DELETE FROM candidate %s ";
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

    @Override
    public String getCountSpl() {
        return null;
    }
}
