package com.emc.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	// /hello?name=kotlin
	@GetMapping("/hello")
	public String mainWithParam(
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model) {

		if (name.equals("")) {
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", name);
		}

		return "welcome"; // view
	}
}
