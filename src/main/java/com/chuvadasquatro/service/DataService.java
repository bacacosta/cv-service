package com.chuvadasquatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuvadasquatro.domain.Data;
import com.chuvadasquatro.repository.DataRepository;

@Service
public class DataService {
	@Autowired
	private DataRepository dataRepository;

	public Data getPages() {
		return dataRepository.getPages();
	}

	public Data getData(String page) {
		return dataRepository.getData(page);
	}
}
