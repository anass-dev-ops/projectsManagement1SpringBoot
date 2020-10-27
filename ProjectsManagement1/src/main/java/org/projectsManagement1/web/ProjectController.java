package org.projectsManagement1.web;

import java.util.List;
import java.util.Optional;

import org.projectsManagement1.entities.Project;
import org.projectsManagement1.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	@Autowired
	private IProjectService iProjectService;

	@GetMapping("/projects")
	public List<Project> getProjects() {
		return iProjectService.getProjects();
	}
	
	@GetMapping("/projects/{idProject}")
	public Project getProjectById(@PathVariable Long idProject) {
		Optional<Project> po = iProjectService.getProjectById(idProject);
		if (po.isPresent()) {
			return po.get();
		}
		return null;
	}
	
	@PostMapping("/projects")
	public Project createProject(@RequestBody Project project) {
		return iProjectService.createProject(project);
	}
}
