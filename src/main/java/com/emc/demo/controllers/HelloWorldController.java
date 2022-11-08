package com.emc.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("HelloWorld")
public class HelloWorldController {

	static final Logger log = LoggerFactory
			.getLogger(HelloWorldController.class);

	@GetMapping("/hello")
	@CrossOrigin
	public String helloWorld(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("helloWorld method started");
		return "Hello " + name + "!!";
	}
}
