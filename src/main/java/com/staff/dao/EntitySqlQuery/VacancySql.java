
package com.staff.dao.EntitySqlQuery;

import com.staff.api.dao.ISqlQuery;

public class VacancySql implements ISqlQuery {
    @Override
    public String getBaseSql() {
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

        return "DELETE FROM vacancy %s";
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

