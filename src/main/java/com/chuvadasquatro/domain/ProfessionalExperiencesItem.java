package com.chuvadasquatro.domain;

import java.util.List;

public class ProfessionalExperiencesItem {
	private String description;
	private List<String> details;
	private Tasks tasks;
	private Achievements achievements;

	public ProfessionalExperiencesItem(String description,
			List<String> details, Tasks tasks, Achievements achievements) {
		this.description = description;
		this.details = details;
		this.tasks = tasks;
		this.achievements = achievements;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public Achievements getAchievements() {
		return achievements;
	}

	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}
}
