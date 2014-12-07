package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.Interests;
import com.chuvadasquatro.service.InterestsService;

@RestController
public class InterestsController {
	@Autowired
	private InterestsService interestsService;

	@RequestMapping("/interests/")
	public Interests getInterests() {
		return interestsService.getInterests();
	}
}
