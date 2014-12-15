package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.PersonalInfo;

@Repository
public class PersonalInfoRepository {
	@Autowired
	private ODFDataSource dataSource;

	public PersonalInfo getPersonalInfo() {
		return new PersonalInfo(dataSource.getData(dataSource.getListIterator("info")));
	}
}
