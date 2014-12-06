package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Skills;

@Repository
public class SkillsRepository {
	public Skills getSkills() {
		List<String> skills = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			skills.add("Skill " + i);
		}
		return new Skills(skills);
	}
}
