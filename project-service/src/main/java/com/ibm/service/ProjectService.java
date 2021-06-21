package com.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.ibm.Entity.Project;
import com.ibm.repo.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	//@Transactional
	public String createProject(Project project) {
		Project saveProject = projectRepository.save(project);
		return saveProject.getId();
	}

	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	public Optional<Project> getProject(String id) {
		return projectRepository.findById(id);
	}

	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	public void deleteProject(String id) {
		projectRepository.deleteById(id);
	}

}
