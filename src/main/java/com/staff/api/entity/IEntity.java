package com.staff.api.entity;

public interface IEntity<T> {
    void setForeignKey(String foreignKey);
    String getForeignKey();
}
