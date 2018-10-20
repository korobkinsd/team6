package com.staff.api.dao;

public interface ISqlQuery {
    String getBaseSql();
    String getSaveSql();
    String getUpdateSql();
    String getDeleteSql();
    String getFullSql();
    String getSpecificationSql();
    String getSortSql();
    String getPagingSql();
}
