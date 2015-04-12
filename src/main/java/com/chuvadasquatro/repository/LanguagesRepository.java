package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Languages;

@Repository
public class LanguagesRepository {
	@Autowired
	private ODFDataSource dataSource;

	public Languages getLanguages() {
		return new Languages(dataSource.getData(dataSource.getListIterator("languages")));
	}
}
