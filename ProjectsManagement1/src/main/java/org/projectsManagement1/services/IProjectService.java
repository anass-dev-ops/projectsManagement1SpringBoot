package org.projectsManagement1.services;

import java.util.List;
import java.util.Optional;

import org.projectsManagement1.entities.Project;

public interface IProjectService {
	public Project createProject(Project project);
	public Optional<Project> getProjectById(Long idProject);
	// public Project getProjectByTitle(String title);
	public List<Project> getProjects();
	public void deleteProject(Long idProject);
}