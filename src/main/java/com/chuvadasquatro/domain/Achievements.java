package com.chuvadasquatro.domain;

import java.util.List;

public class Achievements {
	private String label;
	private List<String> achievements;

	public Achievements(List<String> achievements) {
		this.label = "Achievements:";
		this.achievements = achievements;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<String> achievements) {
		this.achievements = achievements;
	}
}
