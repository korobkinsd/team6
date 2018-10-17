package com.staff.service;

import com.staff.api.dao.IUserDao;
import com.staff.api.service.IUserService;
import com.staff.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends CrudService<User> implements IUserService {

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.dao = userDao;
	}

}