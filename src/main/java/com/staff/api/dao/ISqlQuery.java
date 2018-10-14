package com.staff.api.dao;

public interface ISqlQuery {
    String getFindByIdSql();
    String getFindAllSql();
    String getSaveSql();
    String getUpdateSql();
    String getDeleteSql();
}
