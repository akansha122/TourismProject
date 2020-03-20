package com.zensar.controllers;

/*@author Akansha Shah
@Creation_date 19/02/2020 12:30PM
@Modification_date 19/02/2020 12:30PM
@copyright Zensar technologies. All rights reserved.
@version 2.0
*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.entities.User;
import com.zensar.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/user/dashboard") public List<User> getAllUsers() {
	 * 
	 * }
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long userId) {
		return userService.getByUserId(userId);
	}

	@PostMapping("/user/add")
	public String add(@RequestBody User user) {
		userService.addUser(user);
		return "new User" + user.getUserId() + "is added succesfully";
	}

	@PutMapping("/user/update")
	public String update(@RequestBody User user) {
		userService.updateUser(user);
		return "new User" + user.getUserId() + "is updated succesfully";
	}

	@DeleteMapping("/user/delete")
	public String delete(@RequestBody User user) {
		userService.deleteUser(user);
		return "new User" + user.getUserId() + "is deleted succesfully";
	}
}
