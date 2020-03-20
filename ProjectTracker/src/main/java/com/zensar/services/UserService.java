package com.zensar.services;

import java.util.List;

import com.zensar.entities.User;

public interface UserService {
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> findAllUsers();

	public User getByUserId(Long userId);
	
	public User getByUserName(String userName);
}
