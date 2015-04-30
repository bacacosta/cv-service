package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
