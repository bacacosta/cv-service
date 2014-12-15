package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Skills;

@Repository
public class SkillsRepository {
	@Autowired
	private ODFDataSource dataSource;

	public Skills getSkills() {
		return new Skills(dataSource.getData(dataSource.getListIterator("skills")));
	}
}
