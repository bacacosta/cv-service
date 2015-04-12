package com.chuvadasquatro.domain;

import java.util.List;

public class Interests {
	private List<String> interests;

	public Interests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
}
