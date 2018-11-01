package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "userroles", schema = "team6", catalog = "")
public class UserrolesEntity {
    private int idUser;
    private int idRole;
    private UserEntity userByIdUser;
    private RoleEntity roleByIdRole;

    @Basic
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "idRole")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserrolesEntity that = (UserrolesEntity) o;

        if (idUser != that.idUser) return false;
        if (idRole != that.idRole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + idRole;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idRole", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }
}
