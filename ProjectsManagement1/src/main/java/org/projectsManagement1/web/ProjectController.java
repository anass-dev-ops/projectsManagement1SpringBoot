package org.projectsManagement1.web;

import java.util.List;

import javax.validation.Valid;

import org.projectsManagement1.entities.Project;
import org.projectsManagement1.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private IProjectService iProjectService;

	@GetMapping
	public List<Project> getProjects() {
		return iProjectService.getProjects();
	}
	
	@GetMapping("/{idProject}")
	public Project getProjectById(@PathVariable Long idProject) {
		return iProjectService.getProjectById(idProject);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project createProject(@Valid @RequestBody Project project ) {
		return iProjectService.createProject(project);
	}
	
	@PutMapping
	public Project updateProject(@Valid @RequestBody Project project) {
		return iProjectService.updateProject(project);
	}
	
	@DeleteMapping("/{idProject}")
	public ResponseEntity<String> deleteProject(@PathVariable Long idProject) {
		iProjectService.deleteProject(idProject);
		return ResponseEntity.ok("La Supression est Bien Faite!");
	}
}
