package org.projectsManagement1;

import java.util.stream.Stream;

import org.projectsManagement1.entities.Project;
import org.projectsManagement1.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TesingDB implements CommandLineRunner{
	
	@Autowired
	private IProjectService iProjectService;

	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("Project1", "Project2", "Project3").forEach(projectTitle -> {
			Project project = new Project();
			project.setTitle(projectTitle);
			iProjectService.createProject(project);
		});
		
		/*
		Project project1 = new Project();
		project1.setTitle("TestGestionTache");
		iProjectService.createProject(project1);
		*/
	}

}
