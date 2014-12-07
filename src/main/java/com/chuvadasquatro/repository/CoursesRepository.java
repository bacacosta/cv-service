package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.domain.Courses;

@Repository
public class CoursesRepository {
	public Courses getCourses() {
		List<String> courses = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			courses.add("Courses " + i);
		}
		return new Courses(courses);
	}
}
