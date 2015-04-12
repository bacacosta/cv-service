package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuvadasquatro.domain.Courses;
import com.chuvadasquatro.service.CoursesService;

@RestController
public class CoursesController {
	@Autowired
	private CoursesService coursesService;

	@RequestMapping("/courses/")
	public Courses getCourses() {
		return coursesService.getCourses();
	}
}
