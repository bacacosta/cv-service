package com.chuvadasquatro.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chuvadasquatro.domain.Data;
import com.chuvadasquatro.service.DataService;

@RestController
public class DataController {
	@Autowired
	private DataService dataService;

	@RequestMapping("/pages")
	public Data getPages() {
		return dataService.getPages();
	}

	@RequestMapping("/{page}")
	public Data getData(@PathVariable String page) {
		return dataService.getData(page);
	}

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public Boolean uploadData(@RequestParam("data") MultipartFile data) throws IOException {
		if (data.isEmpty()) {
			throw new RuntimeException("Data is empty.");
		}

		return dataService.saveData(data);
	}
}
