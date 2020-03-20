package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.entities.User;
import com.zensar.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public User getByUserId(Long userId) throws UserNotFoundException {
	 * Optional<User> user = userRepo.findById(userId); return user.orElseThrow(()
	 * -> new UserNotFoundException("Couldn't find a User with id: " + userId)); }
	 */
	/*
	 * @Override public User getByUserName(String userName) throws
	 * UserNotFoundException { // TODO Auto-generated method stub return null; }
	 */

	/*
	 * @Override public User getByUserName(String userName) throws
	 * UserNotFoundException { User user = (User) userRepo.findByFName(userName);
	 * return user; }
	 */

}
