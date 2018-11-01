package com.staff.api.sort;

public interface ISort {
    String getColumnName();
    ISort setColumnName(String columnName);
    String getSortOrder();
    ISort setSortOrder(String sortOrder);

    String Builder();
}
