package com.staff.api.entity;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import javax.persistence.*;

@Entity
@Table(name = "users", schema = "staff")
public class User implements IEntity<User> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Basic
    @Column(name = "name")
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
    private String name;

    @Basic
    @Column(name = "email")
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
    private String email;

    @Basic
    @Column(name = "password")
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
    private String password;

    @Basic
    @Column(name = "surname")
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
    private String surname;


	public boolean isNew() {
		return this.id == null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", surname=" + surname
				+ "]";
	}

	@Override
	public void setForeignKey(String foreignKey) {
		this.id = Integer.parseInt(foreignKey);
	}

	@Override
	public String getForeignKey() {
		/*TODO: не думаю, что это правильно, но не придумал, как сделать лучше*/
		return this.id != null ? this.id.toString() : "0000000000000000000000000000";
	}
}
