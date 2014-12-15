package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Interests;

@Repository
public class InterestsRepository {
	@Autowired
	private ODFDataSource dataSource;

	public Interests getInterests() {
		return new Interests(dataSource.getData(dataSource.getListIterator("interests")));
	}
}
