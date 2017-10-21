package com.chuvadasquatro.cv.web;

import com.chuvadasquatro.cv.domain.Section;
import com.chuvadasquatro.cv.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(SectionController.URL)
public class SectionController {

	public static final String URL = "/sections";

	@Autowired
	private SectionService sectionService;

	@GetMapping
	public Section readAll() {
		return sectionService.readAll();
	}

	@GetMapping(path = "/{section}")
	public Section read(@PathVariable String section) {
		return sectionService.read(section);
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void create(@RequestParam(required = true) MultipartFile file) {
		sectionService.create(file);
	}

}
