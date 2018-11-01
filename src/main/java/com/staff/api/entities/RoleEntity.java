package com.staff.api.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "team6", catalog = "")
public class RoleEntity {
    private int id;
    private String name;
    private byte isAdmin;
    private Collection<UserrolesEntity> userrolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "isAdmin")
    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (isAdmin != that.isAdmin) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) isAdmin;
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<UserrolesEntity> getUserrolesById() {
        return userrolesById;
    }

    public void setUserrolesById(Collection<UserrolesEntity> userrolesById) {
        this.userrolesById = userrolesById;
    }
}
