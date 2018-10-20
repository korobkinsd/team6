package com.staff.api.entity;

import java.util.List;

public class User implements IEntity<User> {
	// form:hidden - hidden value
	Integer id;

	// form:input - textbox
	String name;

	// form:input - textbox
	String email;

	// form:input - password
	String password;

	String surname;


	public boolean isNew() {
		return (this.id == null);
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
