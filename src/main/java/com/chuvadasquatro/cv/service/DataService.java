package com.chuvadasquatro.cv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chuvadasquatro.cv.domain.Data;
import com.chuvadasquatro.cv.repository.DataRepository;

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

	public Boolean saveData(MultipartFile data) throws Exception {
		return dataRepository.saveData(data);
	}

}
