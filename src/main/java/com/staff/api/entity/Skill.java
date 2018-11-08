package com.staff.api.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "skill", schema = "team6")
public class Skill implements IEntity<Skill> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=3, max=80, message="Your full name must be between 3 and 80 characters long.")
    @Pattern(regexp="[A-Za-z]", message="Only letters")
    @Column(name = "name")
    private String name;

    public boolean isNew() {
        return this.name == null;
    }


    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Skill skill = (Skill) o;
        return name == skill.name;
    }

    @Override
    public final int hashCode() {
        return Objects.hash( name);
    }

    @Override
    public final String toString() {
        return "Skill [" +" name='" + name +"]";
    }

    @Override
    public final void setForeignKey(final String foreignKey) {
        this.name = foreignKey;
    }

    @Override
    public final String getForeignKey() {
        return this.name != null ? this.name : "0000000000000000000000000000";
    }


}
