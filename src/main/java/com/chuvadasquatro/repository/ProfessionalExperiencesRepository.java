package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Achievements;
import com.chuvadasquatro.domain.ProfessionalExperiences;
import com.chuvadasquatro.domain.ProfessionalExperiencesItem;
import com.chuvadasquatro.domain.Tasks;

@Repository
public class ProfessionalExperiencesRepository {
	public ProfessionalExperiences getProfessionalExperiences() {
		List<String> details = Arrays.asList("Details 1", "Details 2");
		Tasks tasks = new Tasks(Arrays.asList("Task 1", "Task 2", "Task 3", "Task 4"));
		Achievements achievements = new Achievements(Arrays.asList("Achievements 1", "Achievements 2", "Achievements 3", "Achievements 4"));
		List<ProfessionalExperiencesItem> professionalExperiences = new ArrayList<ProfessionalExperiencesItem>();
		for (int i = 1; i <= 8; i++) {
			ProfessionalExperiencesItem professionalExperiencesItem = new ProfessionalExperiencesItem("Experience " + i, details, tasks, achievements);
			professionalExperiences.add(professionalExperiencesItem);
		}
		return new ProfessionalExperiences(professionalExperiences);
	}
}
