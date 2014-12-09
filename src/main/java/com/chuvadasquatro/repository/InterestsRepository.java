package com.chuvadasquatro.repository;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Interests;

@Repository
public class InterestsRepository {
	public Interests getInterests() {
		return new Interests(ODFDataSource.getData("interests"));
	}
}
