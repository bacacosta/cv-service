package com.chuvadasquatro.domain;

import java.util.List;

public class Education {
	private List<EducationItem> education;

	public Education(List<EducationItem> education) {
		this.education = education;
	}

	public List<EducationItem> getEducation() {
		return education;
	}

	public void setEducation(List<EducationItem> education) {
		this.education = education;
	}
}
