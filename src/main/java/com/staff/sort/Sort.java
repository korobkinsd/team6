package com.staff.sort;

import com.staff.api.sort.ISort;

public class Sort implements ISort {

    protected String columnName;
    protected String sortType;

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public void setColumnName(String columnName) {
        if (columnName == null){
            this.columnName = "id";
        }else{
            this.columnName = columnName;
        }
    }

    @Override
    public String getSortType() {
        return sortType;
    }

    @Override
    public void setSortType(String sortType) {
        if (sortType == null){
            this.sortType = "";
        }else{
            this.sortType = sortType;
        }
    }
}
