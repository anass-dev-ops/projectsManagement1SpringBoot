package org.projectsManagement1.dao;

import org.projectsManagement1.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	public Project findByTitle(String title);
}