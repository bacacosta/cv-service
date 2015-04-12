package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.PersonalInfo;
import com.chuvadasquatro.service.PersonalInfoService;

@RestController
public class PersonalInfoController {
	@Autowired
	private PersonalInfoService personalInfoService;

	@RequestMapping("/info/")
	public PersonalInfo getPersonalInfo() {
		return personalInfoService.getPersonalInfo();
	}
}
