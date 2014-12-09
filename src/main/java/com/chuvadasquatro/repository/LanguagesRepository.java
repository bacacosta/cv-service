package com.chuvadasquatro.repository;

import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Languages;

@Repository
public class LanguagesRepository {
	public Languages getLanguages() {
		return new Languages(ODFDataSource.getData("languages"));
	}
}
