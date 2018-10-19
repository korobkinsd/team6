package com.staff.dao.EntitySqlQueryImpl;

import com.staff.api.dao.ISqlQuery;

public class VacancySql implements ISqlQuery {
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

}
