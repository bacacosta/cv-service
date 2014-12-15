package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Courses;

@Repository
public class CoursesRepository {
	@Autowired
	private ODFDataSource dataSource;

	public Courses getCourses() {
		return new Courses(dataSource.getData(dataSource.getListIterator("courses")));
	}
}
