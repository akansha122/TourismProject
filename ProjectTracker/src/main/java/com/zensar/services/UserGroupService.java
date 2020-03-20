package com.zensar.services;

import java.util.List;
import java.util.Optional;

import com.zensar.entities.UserGroup;

public interface UserGroupService {

	public void addUserGroup(UserGroup userGroup);
	public void updateUserGroup(UserGroup userGroup);
	public void deleteUserGroup(UserGroup userGroup);
	public Optional<UserGroup> getByUserGroupId(Long userGroupId);
	public List<UserGroup> getAllByUserGroup();
	
}
