package org.projectsManagement1.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.projectsManagement1.dao.ProjectRepository;
import org.projectsManagement1.entities.Project;
import org.projectsManagement1.services.imp.ProjectServiceImp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProjectServiceTest {
	
	Project project1 = new Project(1L, "Gestion de Tests1", "Desc1", LocalDate.now(), LocalDate.now());
	Project project2 = new Project(2L, "Gestion de Tests2", "Desc2", LocalDate.now(), LocalDate.now());
	Project project3 = new Project(3L, "Gestion de Tests3", "Desc3", LocalDate.now(), LocalDate.now());
	List<Project> projects;

	@MockBean
	private ProjectRepository projectRepository;
	
	@InjectMocks
	private ProjectServiceImp projectServiceImp;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
	}
	
	
	@Test
	public void whenGetProjects_returnProjectsList() {
		//Given
		given(projectRepository.findAll()).willReturn(projects);
		
		List<Project> result = projectServiceImp.getProjects();
		//Assert
		assertThat(result)
					.hasSize(3)
					.contains(project1, project2, project3);
		
		assertThat(result.get(0)).isInstanceOf(Project.class);
		assertThat(result.get(0).getId()).isInstanceOf(Long.class);
		assertThat(result.get(0).getId()).isEqualTo(1L);
		assertThat(result.get(0).getTitle()).isEqualTo("Gestion de Tests1");
	}
	

}
