package com.chuvadasquatro.domain;

import java.util.List;

public class EducationItem {
	private String description;
	private List<String> studyPoints;

	public EducationItem(String description, List<String> studyPoints) {
		this.description = description;
		this.studyPoints = studyPoints;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getStudyPoints() {
		return studyPoints;
	}

	public void setStudyPoints(List<String> studyPoints) {
		this.studyPoints = studyPoints;
	}
}
