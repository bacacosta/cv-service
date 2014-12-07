package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.ProfessionalExperiences;
import com.chuvadasquatro.service.ProfessionalExperiencesService;

@RestController
public class ProfessionalExperiencesController {
	@Autowired
	private ProfessionalExperiencesService professionalExperiencesService;

	@RequestMapping("/experiences/")
	public ProfessionalExperiences getProfessionalExperiences() {
		return professionalExperiencesService.getProfessionalExperiences();
	}
}
