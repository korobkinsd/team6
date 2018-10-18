package com.staff.api.dao;

public interface ISqlQuery {
    String getBaseSql();
    String getFindByIdSql();
    String getFindAllSql();
    String getSaveSql();
    String getUpdateSql();
    String getDeleteSql();
    String getCompositeSql();
    String getSpecificationSql();
    String getSortSql();
    String getPagingSql();
}
