package com.example.websitepractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class test {
	@GetMapping("/")
	public String testPage(){
		return "test.html";
	}
}
