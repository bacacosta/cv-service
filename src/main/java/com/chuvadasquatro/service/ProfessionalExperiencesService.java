package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.ProfessionalExperiences;
import com.chuvadasquatro.repository.ProfessionalExperiencesRepository;

@Service
public class ProfessionalExperiencesService {
	@Autowired
	private ProfessionalExperiencesRepository professionalExperiencesRepository;

	public ProfessionalExperiences getProfessionalExperiences() {
		return professionalExperiencesRepository.getProfessionalExperiences();
	}
}
