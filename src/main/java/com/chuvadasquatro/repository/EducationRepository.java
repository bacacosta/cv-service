package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Education;
import com.chuvadasquatro.domain.EducationItem;

@Repository
public class EducationRepository {
	public Education getEducation() {
		List<String> studyPoints = Arrays.asList("Study point 1", "Study point 2");
		List<EducationItem> education = new ArrayList<EducationItem>();
		for (int i = 1; i <= 2; i++) {
			EducationItem educationItem = new EducationItem("Education " + i, studyPoints);
			education.add(educationItem);
		}
		return new Education(education);
	}
}
