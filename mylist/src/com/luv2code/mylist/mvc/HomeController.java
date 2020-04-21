package com.luv2code.mylist.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getMainMenu() {
		return "main-menu";
	}
}
