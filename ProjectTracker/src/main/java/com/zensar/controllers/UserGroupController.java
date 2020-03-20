package com.zensar.controllers;

/*@author Akansha Shah
@Creation_date 19/02/2020 12:30PM
@Modification_date 19/02/2020 12:30PM
@copyright Zensar technologies. All rights reserved.
@version 2.0
*/
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.entities.UserGroup;
import com.zensar.services.UserGroupService;

@RestController
public class UserGroupController {
	@Autowired
	private UserGroupService userGroupService;

	@GetMapping("/usergroups")
	public List<UserGroup> getAllGroups() {
		return userGroupService.getAllByUserGroup();
	}

	@GetMapping("/usergroup/{id}")
	public Optional<UserGroup> getGroup(@PathVariable("id") Long groupId) {
		return userGroupService.getByUserGroupId(groupId);
	}

	@PostMapping("/usergroup/add")
	public String add(@RequestBody UserGroup userGroup) {
		userGroupService.addUserGroup(userGroup);
		return "new Group" + userGroup.getUserGroupId() + "is added succesfully";
	}

	@PutMapping("/usergroup/update")
	public String update(@RequestBody UserGroup usergroup) {
		userGroupService.updateUserGroup(usergroup);
		return "Groject" + usergroup.getUserGroupId() + "is updated succesfully";
	}

	@DeleteMapping("/usergroup/delete")
	public String delete(@RequestBody UserGroup usergroup) {
		userGroupService.deleteUserGroup(usergroup);
		return "Group" + usergroup.getUserGroupId() + "is deleted succesfully";
	}
}
