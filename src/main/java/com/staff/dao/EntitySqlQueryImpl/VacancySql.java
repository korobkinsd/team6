/*
package com.staff.dao.EntitySqlQueryImpl;

import com.staff.api.dao.ISqlQuery;

public class VacancySql implements ISqlQuery {
    @Override
    public String getBaseSql() {
        return "SELECT * FROM user";
    }
    @Override
    public String getFindByIdSql() {
        return "SELECT * FROM vacancy WHERE id=:id";
    }

    @Override
    public String getFindAllSql() {
        return "SELECT * FROM vacancy";
    }

    @Override
    public String getSaveSql() {
        return "INSERT INTO vacancy(position, idDeveloper,salaryFrom ,salaryTo ,experienceYearsRequire ) "
                + "VALUES ( :position, :iddeveloper, :salaryfrom, :salaryto, :experienceyearsrequire)";
    }

    @Override
    public String getUpdateSql() {
        return "UPDATE vacancy SET position=:position,  salaryFrom=:salaryfrom, salaryTo=:salaryto, experienceYearsRequire=:experienceyearsrequire WHERE id=:id";
    }

    @Override
    public String getDeleteSql() {
        return "DELETE FROM vacancy WHERE id= :id";
    }


    @Override
    public String getCompositeSql() {
        */
/*%1$s - для WHERE, %2$s - для ORDER BY*//*

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
*/
