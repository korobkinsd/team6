package com.staff.dao.sort;

import com.staff.api.enums.Sort.SortOrder;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.sort.ISort;

public class Sort implements ISort {

    protected SortUserFields columnName;
    protected SortOrder sortOrder;

    @Override
    public String getColumnName() {
        return columnName != null ? columnName.toString() : "";
    }

    @Override
    public ISort setColumnName(String columnName) {
        if (columnName == null || columnName.isEmpty()){
            this.columnName = SortUserFields.ID;
        }else{
            this.columnName = SortUserFields.valueOf(columnName.trim().toUpperCase());
        }
        return this;
    }

    @Override
    public ISort setColumnName(SortUserFields columnName) {
        this.columnName = columnName;
        return this;
    }

    @Override
    public String getSortOrder() {
        return sortOrder != null ? sortOrder.toString() : "";
    }

    @Override
    public ISort setSortOrder(String sortOrder) {
        if (sortOrder == null || sortOrder.isEmpty()){
            this.sortOrder = SortOrder.ASC;
        }else{
            this.sortOrder = SortOrder.valueOf(sortOrder.trim().toUpperCase());
        }
        return this;
    }

    @Override
    public ISort setSortOrder(SortOrder sortOrder) {
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
