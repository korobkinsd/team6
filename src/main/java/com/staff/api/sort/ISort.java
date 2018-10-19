package com.staff.api.sort;

import com.staff.api.enums.Sort.SortOrder;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.enums.Sort.SortVacancyFields;

public interface ISort {
    String getColumnName();
    ISort setColumnName(String columnName);
    ISort setColumnName(SortUserFields columnName);
    ISort setColumnName(SortVacancyFields columnName);
    String getSortOrder();
    ISort setSortOrder(String sortOrder);
    ISort setSortOrder(SortOrder sortOrder);

    String Builder();
}
