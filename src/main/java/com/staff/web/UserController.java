package com.staff.web;

import javax.transaction.Transactional;
import javax.validation.Valid;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.staff.api.dao.IUserDao;
import com.staff.api.entity.User;
import com.staff.api.repository.IUserRepository;
import com.staff.api.specification.IUserSpecification;
import com.staff.dao.repository.UserRepository;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntitySpecification.UserSpecification;
import com.staff.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	//@Autowired
	protected IUserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
    @Transactional
	public @ResponseBody List<User> showAllUsers(@RequestParam(value = "filter") String filter,
							   @RequestParam(value = "columnName", defaultValue ="NAME") String columnName,
							   @RequestParam(value = "order", defaultValue = "ASC") String order,
							   @RequestParam(value = "page", defaultValue = "1") int page,
							   @RequestParam(value = "pagesize", defaultValue = "5") int pagesize) throws IOException {

		logger.debug("showAllUsers()");
		ObjectMapper mapper = new ObjectMapper();
		User userFilter = mapper.readValue(filter, User.class);

		IUserSpecification specUser = new UserSpecification();
		if (userFilter != null){
			specUser = specUser.GetByNameLike(userFilter.getName())
					.GetAnd().GetByEmailLike(userFilter.getEmail()).GetAnd().GetBySurnameLike(userFilter.getSurname());
		}
		List<User> users = userRepository.FindWithPaging(specUser,
				new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);

		//return mapper.writeValueAsString(users);
		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User showUser(@PathVariable("id") int id) {

		logger.debug("showUser() id: {}", id);

		User user = userRepository.Read(new UserSpecification().GetById(id));
		if (user != null){
			return user;
		}else{
			throw new ResourceNotFoundException();
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody User saveUser(@Valid @RequestBody User user,
			BindingResult result) throws BindException{

		logger.debug("saveUser() : {}", user);

		if (result.hasErrors()) {
			throw new BindException(result);
		} else {
			userRepository.save(user);
			return user;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@PathVariable("id") int id, @Valid @RequestBody User user,
						   BindingResult result) throws BindException{

		logger.debug("saveOrUpdateUser() : {}", user);

		if (result.hasErrors()) {
			throw new BindException(result);
		} else {

			User updUser = userRepository.Read(new UserSpecification().GetById(id));
			if (updUser== null) {
				throw new ResourceNotFoundException();
			} else {
				updUser.setName(user.getName());
				updUser.setEmail(user.getEmail());
				updUser.setPassword(user.getPassword());
				updUser.setSurname(user.getSurname());
				userRepository.update(updUser);
			}
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") int id) {

		logger.debug("deleteUser() : {}", id);


		User user = userRepository.Read(new UserSpecification().GetById(id));
		if (user != null){
			userRepository.delete(new UserSpecification().GetById(id));
		}else{
			throw new ResourceNotFoundException();
		}
	}
}