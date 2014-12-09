package com.chuvadasquatro.repository;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Skills;

@Repository
public class SkillsRepository {
	public Skills getSkills() {
		return new Skills(ODFDataSource.getData("skills"));
	}
}
