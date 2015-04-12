package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Interests;
import com.chuvadasquatro.repository.InterestsRepository;

@Service
public class InterestsService {
	@Autowired
	private InterestsRepository interestsRepository;

	public Interests getInterests() {
		return interestsRepository.getInterests();
	}
}
