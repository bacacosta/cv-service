package com.chuvadasquatro.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;

@Repository
public class DataRepository {
	@Autowired
	private ODFDataSource dataSource;

	public void getData(String title) {
		
	}
}
