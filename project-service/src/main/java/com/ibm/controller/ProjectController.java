package com.ibm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.ibm.Entity.Project;
import com.ibm.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@PostMapping("/project")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createProject(@RequestBody @Valid Project project, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(project);
		return projectService.createProject(project);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry!");
		}
	}

	@GetMapping("/project")
	List<Project> getprojects() {
		return projectService.getProjects();
	}

	@GetMapping("/project/{id}")
	Optional<Project> getProject(@RequestBody @PathVariable("id") String Id) {
		return projectService.getProject(Id);
	}

	@PutMapping("/project/{id}")
	void updateProject(@RequestBody @Valid Project project, BindingResult bindingResult, @PathVariable("id") String Id) {
		validateModel(bindingResult);
		// System.out.println(Id);
		project.setId(Id);
		projectService.updateProject(project);
	}
}
