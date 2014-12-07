package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Languages;

@Repository
public class LanguagesRepository {
	public Languages getLanguages() {
		List<String> languages = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			languages.add("Languages " + i);
		}
		return new Languages(languages);
	}
}
