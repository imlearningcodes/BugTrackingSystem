package com.ibm.Entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class Bug {
	@Id
	private String id;
	//@Size(min = 5, max = 100)
	private String description;
	@NotNull
	private STATUS status;
	 @NotNull
	private Date submittedOn;
	 @NotNull
	private String name;
	private String module;
    @NotNull
	private String projectId;
	private PRIORITY priority;
	private SEVERITY severity;
	private Date ETA;
	private TYPE type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		if (submittedOn.compareTo(new Date()) > 0) {
			throw new IllegalArgumentException("DOB cannot be future date");
		}
		this.submittedOn = submittedOn;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		
		//if(status==STATUS.CLOSED) {
			//throw new IllegalArgumentException("Bug cannot be closed untill it is fixed");
			
			
		//}
		this.status = status;
	}

	public PRIORITY getPriority() {
		return priority;
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public Date getETA() {
		return ETA;
	}

	public void setETA(Date eTA) {
		ETA = eTA;
	}

}