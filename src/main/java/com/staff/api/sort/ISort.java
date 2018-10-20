package com.staff.api.sort;

import com.staff.api.enums.Sort.SortOrder;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.enums.Sort.SortVacancyFields;

public interface ISort {
    String getColumnName();
    ISort setColumnName(String columnName);
    String getSortOrder();
    ISort setSortOrder(String sortOrder);

    String Builder();
}
