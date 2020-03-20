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

import com.zensar.entities.Status;
import com.zensar.services.StatusService;

@RestController
public class StatusContoller {
	@Autowired
	private StatusService statusService;

	@GetMapping("/status")
	public List<Status> getAllStatus() {
		return statusService.getAllByStatus();
	}

	@GetMapping("/status/{id}")
	public Optional<Status> getStatus(@PathVariable("id") Long statusId) {
		return statusService.getByStatusId(statusId);
	}

	@PostMapping("/status/add")
	public String add(@RequestBody Status status) {
		statusService.addStatus(status);
		return "new status" + status.getStatusId() + "is added succesfully";
	}

	@PutMapping("/status/update")
	public String update(@RequestBody Status status) {
		statusService.updateStatus(status);
		return "Status" + status.getStatusId() + "is updated succesfully";
	}

	@DeleteMapping("/status/delete")
	public String delete(@RequestBody Status status) {
		statusService.deleteStatus(status);
		return "Status" + status.getStatusId() + "is deleted succesfully";
	}
}
