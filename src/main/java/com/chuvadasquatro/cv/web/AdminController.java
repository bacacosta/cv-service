package com.chuvadasquatro.cv.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@RequestMapping("/")
	public String index(@RequestParam(value = "success", required = false) String success, Model model) {
		model.addAttribute("success", success);
		return "index";
	}

}
