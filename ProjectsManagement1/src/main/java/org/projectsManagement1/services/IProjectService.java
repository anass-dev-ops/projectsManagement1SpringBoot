package org.projectsManagement1.services;

import java.util.List;

import org.projectsManagement1.entities.Project;

public interface IProjectService {
	public Project createProject(Project project);
	public Project updateProject(Project project);
	public Project getProjectById(Long idProject);
	public List<Project> getProjects();
	public void deleteProject(Long idProject);
}