package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class InterviewSql implements ISqlQuery {
    @Override
    public String getBaseSql() {
        return "SELECT id, idVacancy, idCandidate, planDate, factDate FROM interview";
    }

    @Override
    public String getSaveSql() {
        return "INSERT INTO INTERVIEW(idVacancy, idCandidate, planDate, factDate) "
                + "VALUES ( :idVacancy, :idCandidate, :planDate, :factDate)";
    }

    @Override
    public String getUpdateSql() {
        return "UPDATE INTERVIEW SET idVacancy=:idVacancy, idCandidate=:idCandidate, planDate=:planDate, "
                + "factDate=:factDate WHERE id=:id";
    }

    @Override
    public String getDeleteSql() {
        return "DELETE FROM INTERVIEW %s ";
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