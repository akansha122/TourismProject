package com.zensar.services;

import java.util.List;
import java.util.Optional;

import com.zensar.entities.Project;

public interface ProjectService {

	public void addProject(Project project);

	public void updateProject(Project project);

	public void deleteProject(Project project);

	public Optional<Project> getByProjectId(Long projectId);

	public List<Project> getAll();

}
