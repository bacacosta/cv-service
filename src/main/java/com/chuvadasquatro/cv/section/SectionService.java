package com.chuvadasquatro.cv.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectionRepository;

	public Section readAll() {
		return sectionRepository.readAll();
	}

	public Section read(String section) {
		return sectionRepository.read(section);
	}

	public Boolean create(MultipartFile file) {
		return sectionRepository.create(file);
	}

}
