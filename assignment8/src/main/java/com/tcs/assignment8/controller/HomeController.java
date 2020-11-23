package com.tcs.assignment8.controller;

import javax.swing.SwingContainer;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.assignment8.model.Login;
import com.tcs.assignment8.repository.LoginRepository;

@Controller
public class HomeController {

	@Autowired
	LoginRepository loginR;
	//@GetMapping("/")
	@RequestMapping(path = {"/"},method=RequestMethod.GET)
	public String getHomePage() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute @Valid Login login,BindingResult result)
	{
		ModelAndView mv = new  ModelAndView();
		loginR.save(login);
		mv.setViewName("redirect:/auth/login.html");
		return mv;
	}
	
}
