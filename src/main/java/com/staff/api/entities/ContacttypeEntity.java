package com.staff.api.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "contacttype", schema = "team6", catalog = "")
public class ContacttypeEntity {
    private int id;
    private String name;
    private Collection<ContactdetailsEntity> contactdetailsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContacttypeEntity that = (ContacttypeEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "contacttypeByIdContactType")
    public Collection<ContactdetailsEntity> getContactdetailsById() {
        return contactdetailsById;
    }

    public void setContactdetailsById(Collection<ContactdetailsEntity> contactdetailsById) {
        this.contactdetailsById = contactdetailsById;
    }
}
