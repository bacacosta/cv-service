package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Languages;
import com.chuvadasquatro.repository.LanguagesRepository;

@Service
public class LanguagesService {
	@Autowired
	private LanguagesRepository languagesRepository;

	public Languages getLanguages() {
		return languagesRepository.getLanguages();
	}
}
