package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.Skills;
import com.chuvadasquatro.service.SkillsService;

@RestController
public class SkillsController {
	@Autowired
	private SkillsService skillsService;

	@RequestMapping("/skills/")
	public Skills getSkills() {
		return skillsService.getSkills();
	}
}
