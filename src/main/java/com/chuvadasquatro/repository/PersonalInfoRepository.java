package com.chuvadasquatro.repository;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.PersonalInfo;

@Repository
public class PersonalInfoRepository {
	public PersonalInfo getPersonalInfo() {
		return new PersonalInfo(ODFDataSource.getData(ODFDataSource.getListIterator("info")));
	}
}
