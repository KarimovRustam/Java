package com.test.task.controllers;

import com.test.task.services.interfaces.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingsController {

	@Autowired
	private GreetingsService greetingsService;

	@RequestMapping("/")
	public String kek() { return "redirect:/welcome"; }

	@GetMapping("/welcome")
	public String welcome(Model model,
	                      Authentication authentication) {
		model.addAttribute("message", greetingsService.getGreetingMessage(authentication.getName()));
		return "welcome";
	}
}
