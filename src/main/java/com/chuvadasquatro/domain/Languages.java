package com.chuvadasquatro.domain;

import java.util.List;

public class Languages {
	private List<String> languages;

	public Languages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
}
