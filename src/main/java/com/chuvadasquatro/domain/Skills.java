package com.chuvadasquatro.domain;

import java.util.List;

public class Skills {
	private List<String> skills;

	public Skills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}
