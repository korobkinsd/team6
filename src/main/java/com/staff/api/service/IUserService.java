package com.staff.api.service;

import java.util.List;

import com.staff.api.entity.User;

public interface IUserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);
	
}