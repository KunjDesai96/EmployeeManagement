package com.tcs.assignment8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/auth")
public class AuthController {

	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
}
