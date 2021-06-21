package com.ibm.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

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

import com.ibm.Entity.Bug;
import com.ibm.Service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService;

	Logger logger = Logger.getLogger(BugController.class.getName());

	/**
	 * 
	 * @param createBug     method to create a bug in the database
	 * @param bindingResult
	 * @return
	 */

	@PostMapping("/bug")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		validateModel(bindingResult);
		logger.log(Level.WARNING, "Bug succesfully created");
		return bugService.createBug(bug);
	}

	/**
	 * method to validate all conditions in Bug class
	 * 
	 * @param bindingResult
	 */

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, please retry!");
		}
	}

	/**
	 * method to return all bugs
	 * 
	 * @return
	 */

	@GetMapping("/bug")
	List<Bug> getBugs() {
		return bugService.getBugs();
	}

	/**
	 * method to get a single or no bug information
	 * 
	 * @param bugId
	 * @return
	 */

//	@GetMapping("/bug/{id}")
//	Optional<Bug> getBug(@PathVariable("id") String bugId) {
//		return bugService.getBug(bugId);
//	}
	
	@GetMapping("/bug/{name}")
	Optional<Bug> getBugByName(@PathVariable("name") String bugName) {
		return bugService.getBugByName(bugName);
	}

	/**
	 * method to update any new bug information
	 * 
	 * @param bug
	 * @param bugId
	 * @param bindingResult
	 */

	@PutMapping("/bug/{id}")
	void updateBug(@RequestBody @Valid Bug bug, @PathVariable("id") String bugId, BindingResult bindingResult) {
		validateModel(bindingResult);
		bug.setId(bugId);
		bugService.updateBug(bug);

	}

}
