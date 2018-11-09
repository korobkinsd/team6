package com.staff.dao.sort;

import com.staff.api.sort.ISort;

public class Sort implements ISort {

    private String columnName;
    private String sortOrder;

    @Override
    public String getColumnName() {
        return columnName != null ? columnName : "";
    }

    @Override
    public ISort setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    @Override
    public String getSortOrder() {
        return sortOrder != null ? sortOrder : "";
    }

    @Override
    public ISort setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    @Override
    public String Builder() {
        if (!this.getColumnName().isEmpty() && !this.getSortOrder().isEmpty()){
            return " ORDER BY ".concat(this.getColumnName()).concat(" ").concat(this.getSortOrder()).concat(" ");
        }
        return "";
    }
}
