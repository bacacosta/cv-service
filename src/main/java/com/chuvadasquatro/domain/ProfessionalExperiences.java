package com.chuvadasquatro.domain;

import java.util.List;

public class ProfessionalExperiences {
	private List<ProfessionalExperiencesItem> professionalExperiences;

	public ProfessionalExperiences(List<ProfessionalExperiencesItem> professionalExperiences) {
		this.professionalExperiences = professionalExperiences;
	}

	public List<ProfessionalExperiencesItem> getProfessionalExperiences() {
		return professionalExperiences;
	}

	public void setProfessionalExperiences(List<ProfessionalExperiencesItem> professionalExperiences) {
		this.professionalExperiences = professionalExperiences;
	}
}
