package com.chuvadasquatro.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public Boolean saveData(MultipartFile data) throws IOException {
		return dataRepository.saveData(data);
	}
}
