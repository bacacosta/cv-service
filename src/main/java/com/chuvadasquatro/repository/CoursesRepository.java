package com.chuvadasquatro.repository;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Courses;

@Repository
public class CoursesRepository {
	public Courses getCourses() {
		return new Courses(ODFDataSource.getData("courses"));
	}
}
