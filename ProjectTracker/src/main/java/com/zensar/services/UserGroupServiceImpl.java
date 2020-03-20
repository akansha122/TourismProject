package com.zensar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zensar.entities.UserGroup;
import com.zensar.repository.UserGroupRepository;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	public UserGroupRepository userGroupRepository;

	@Override
	public void addUserGroup(UserGroup userGroup) {
		userGroupRepository.save(userGroup);
	}

	@Override
	public void deleteUserGroup(UserGroup userGroup) {
		userGroupRepository.delete(userGroup);
	}

	@Override
	public Optional<UserGroup> getByUserGroupId(Long userGroupId) {
		return userGroupRepository.findById(userGroupId);
	}

	@Override
	public List<UserGroup> getAllByUserGroup() {
		return userGroupRepository.findAll();
	}

	@Override
	public void updateUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub

	}
}
