package com.tcs.assignment8.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.tcs.assignment8.model.Login;
import com.tcs.assignment8.repository.LoginRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {

	@Autowired
	LoginRepository loginR;
	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login.html")
	public ModelAndView register(@ModelAttribute @Valid Login login,BindingResult result)
	{
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage() + " "+ e.getField());
				
			});
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		if(login.equals(loginR.findById(login.getUserName()).get())) {
			modelAndView.addObject("res", "Login Successfull");
		}
		else {
			modelAndView.addObject("res", "Login Failed");
		}
		
		modelAndView.setViewName("redirect:/auth/result");
		return modelAndView;
	}
	
	@GetMapping("/result")
	public String getResultPage(@ModelAttribute("res") String res, Model model){
		model.addAttribute("res", res);
		return "result";
	}
}
