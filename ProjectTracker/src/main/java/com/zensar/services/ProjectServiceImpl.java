package com.zensar.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zensar.entities.Project;
import com.zensar.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.save(project);
	}

	@Override
	public void updateProject(Project project) {
		// projectRepository.
	}

	@Override
	public void deleteProject(Project project) {
		projectRepository.delete(project);
	}

	@Override
	public Optional<Project> getByProjectId(Long projectId) {
		return projectRepository.findById(projectId);
	}

	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

}
