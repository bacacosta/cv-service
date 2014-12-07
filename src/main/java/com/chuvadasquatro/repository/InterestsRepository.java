package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Interests;

@Repository
public class InterestsRepository {
	public Interests getInterests() {
		List<String> interests = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			interests.add("Interests " + i);
		}
		return new Interests(interests);
	}
}
