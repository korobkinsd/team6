package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "staff", catalog = "")
public class UsersEntity {
    private int id;
    private String name;
    private String email;
    private String address;
    private String password;
    private Byte newsletter;
    private String framework;
    private String sex;
    private Integer number;
    private String country;
    private String skill;

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "newsletter")
    public Byte getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Byte newsletter) {
        this.newsletter = newsletter;
    }

    @Basic
    @Column(name = "framework")
    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "NUMBER")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "SKILL")
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (newsletter != null ? !newsletter.equals(that.newsletter) : that.newsletter != null) return false;
        if (framework != null ? !framework.equals(that.framework) : that.framework != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (skill != null ? !skill.equals(that.skill) : that.skill != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (newsletter != null ? newsletter.hashCode() : 0);
        result = 31 * result + (framework != null ? framework.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        return result;
    }
}
