package com.docker.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestApi {

	@GetMapping("/docker")
	public String showApi() {
		return "This is best api ever which will run on docker engine";
	}
}
