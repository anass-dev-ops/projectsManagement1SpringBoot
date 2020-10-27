package org.projectsManagement1.services.imp;

import java.util.List;
import java.util.Optional;

import org.projectsManagement1.dao.ProjectRepository;
import org.projectsManagement1.entities.Project;
import org.projectsManagement1.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements IProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		Project p = new Project();
		if (projectRepository.findByTitle(project.getTitle()) == null) {
			p = projectRepository.save(project);
		} else {
			System.out.println("The Project is Already exist");
			new RuntimeException("The Project is Already exist");
		}
		return p;
	}

	@Override
	public Optional<Project> getProjectById(Long idProject) {
		return projectRepository.findById(idProject);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(Long idProject) {
		projectRepository.deleteById(idProject);
	}

}
