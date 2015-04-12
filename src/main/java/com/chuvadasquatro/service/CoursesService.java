package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Courses;
import com.chuvadasquatro.repository.CoursesRepository;

@Service
public class CoursesService {
	@Autowired
	private CoursesRepository coursesRepository;

	public Courses getCourses() {
		return coursesRepository.getCourses();
	}
}
