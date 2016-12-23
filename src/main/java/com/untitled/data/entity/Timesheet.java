package com.untitled.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timesheets")
public class Timesheet extends BaseEntity {

	private String name;
	private Date created;

	@ManyToOne
	@JoinColumn(name = "case_id", nullable = false)
	private Case reportedCase;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Case client;
	
	private float time;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Case getReportedCase() {
		return reportedCase;
	}

	public void setReportedCase(Case reportedCase) {
		this.reportedCase = reportedCase;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Case getClient() {
		return client;
	}

	public void setClient(Case client) {
		this.client = client;
	}

}
