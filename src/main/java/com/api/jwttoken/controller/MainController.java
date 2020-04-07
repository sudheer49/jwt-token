package com.api.jwttoken.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/hello")
	public String getHello() {
		System.out.println("Inside hello api");
		return "Hello Wolrd";
	}

}
