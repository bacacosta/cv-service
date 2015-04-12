package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Skills;
import com.chuvadasquatro.repository.SkillsRepository;

@Service
public class SkillsService {
	@Autowired
	private SkillsRepository skillsRepository;

	public Skills getSkills() {
		return skillsRepository.getSkills();
	}
}
