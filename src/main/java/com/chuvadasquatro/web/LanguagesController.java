package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.Languages;
import com.chuvadasquatro.service.LanguagesService;

@RestController
public class LanguagesController {
	@Autowired
	private LanguagesService languagesService;

	@RequestMapping("/languages/")
	public Languages getLanguages() {
		return languagesService.getLanguages();
	}
}
