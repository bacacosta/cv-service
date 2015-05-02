package com.chuvadasquatro.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chuvadasquatro.domain.Data;
import com.chuvadasquatro.service.DataService;

@Controller
public class DataController {
	@Autowired
	private DataService dataService;

	@RequestMapping("/rest/pages")
	public @ResponseBody Data getPages() {
		return dataService.getPages();
	}

	@RequestMapping("/rest/{page}")
	public @ResponseBody Data getData(@PathVariable String page) {
		return dataService.getData(page);
	}

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadData(
			@RequestParam("data") MultipartFile data,
			RedirectAttributes attr
	) throws Exception {
		if (data.isEmpty()) {
			throw new RuntimeException("Data is empty.");
		}

		Boolean success = dataService.saveData(data);

		attr.addAttribute("success", success);
		return "redirect:/";
	}
}
