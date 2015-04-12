package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.PersonalInfo;
import com.chuvadasquatro.repository.PersonalInfoRepository;

@Service
public class PersonalInfoService {
	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	public PersonalInfo getPersonalInfo() {
		return personalInfoRepository.getPersonalInfo();
	}
}
