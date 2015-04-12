package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.Education;
import com.chuvadasquatro.service.EducationService;

@RestController
public class EducationController {
	@Autowired
	private EducationService educationService;

	@RequestMapping("/education/")
	public Education getEducation() {
		return educationService.getEducation();
	}
}
