package com.chuvadasquatro.domain;

import java.util.List;

public class PersonalInfo {
	private List<String> personalInfo;

	public PersonalInfo(List<String> personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<String> getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(List<String> personalInfo) {
		this.personalInfo = personalInfo;
	}
}
