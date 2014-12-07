package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.PersonalInfo;

@Repository
public class PersonalInfoRepository {
	public PersonalInfo getPersonalInfo() {
		List<String> personalInfo = new ArrayList<String>();
		for (int i = 1; i <= 2; i++) {
			personalInfo.add("Personal info " + i);
		}
		return new PersonalInfo(personalInfo);
	}
}
