package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Education;
import com.chuvadasquatro.repository.EducationRepository;

@Service
public class EducationService {
	@Autowired
	private EducationRepository educationRepository;

	public Education getEducation() {
		return educationRepository.getEducation();
	}
}
