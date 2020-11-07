package org.projectsManagement1.services.imp;

import java.util.List;

import javax.validation.Valid;

import org.projectsManagement1.dao.ProjectRepository;
import org.projectsManagement1.entities.Project;
import org.projectsManagement1.exception.ResourceNotFoundException;
import org.projectsManagement1.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements IProjectService {
	
	private final String messageNotFoundRes = "Le Projet Est Introuvable Avec l'Id ";
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(@Valid Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Project project) {
		projectRepository.findById(project.getId())
			.orElseThrow(() -> new ResourceNotFoundException(messageNotFoundRes + project.getId()));
		return projectRepository.save(project);
	}
	
	@Override
	public Project getProjectById(Long idProject) {
		return projectRepository.findById(idProject)
				.orElseThrow(() -> new ResourceNotFoundException(messageNotFoundRes + idProject));
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(Long idProject) {
		Project project = projectRepository.findById(idProject)
				.orElseThrow(() -> new ResourceNotFoundException(messageNotFoundRes + idProject));
		projectRepository.delete(project);
	}


}
