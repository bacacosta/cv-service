package com.chuvadasquatro.cv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

	private static final String REDIRECT_SWAGGER_UI_HTML = "redirect:swagger-ui.html";

	@RequestMapping("/")
	public String home() {
		return REDIRECT_SWAGGER_UI_HTML;
	}

}
