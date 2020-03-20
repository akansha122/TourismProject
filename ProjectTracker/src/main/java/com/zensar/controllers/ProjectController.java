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
import com.zensar.entities.Project;
import com.zensar.services.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectService.getAll();
	}

	@GetMapping("/project/{id}")
	public Optional<Project> getProject(@PathVariable("id") Long projectId) {
		return projectService.getByProjectId(projectId);
	}

	@PostMapping("/project/add")
	public String add(@RequestBody Project project) {
		projectService.addProject(project);
		return "new Project" + project.getProjectId() + "is added succesfully";
	}

	@PutMapping("/project/update")
	public String update(@RequestBody Project project) {
		projectService.updateProject(project);
		return "new Project" + project.getProjectId() + "is updated succesfully";
	}

	@DeleteMapping("/project/delete")
	public String delete(@RequestBody Project project) {
		projectService.deleteProject(project);
		return "new Project" + project.getProjectId() + "is deleted succesfully";
	}
}
