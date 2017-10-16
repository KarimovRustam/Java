package com.test.task.controllers;

import com.test.task.exceptions.BadRequestException;
import com.test.task.services.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;

	@GetMapping("/sign-in")
	public String signIn(Model model,
	                     @CookieValue(value = "login", required = false) String login,
	                     @RequestParam(value = "error", required = false) String error,
	                     Authentication authentication) {
		if (authentication != null)
			return "redirect:/";
		model.addAttribute("login", login);
		if (error != null)
			model.addAttribute("error", "Имя пользователя и пароль не подходят");
		return "signin";
	}

	@PostMapping("/sign-up")
	public String register(Model model,
	                       HttpServletResponse response,
	                       @RequestParam("password") String password,
	                       @RequestParam("login") String login) {
		try {
			authService.register(login, password);
			authService.login(login, password, response);
		} catch (BadRequestException ex) {
			model.addAttribute("error", ex.getMessage());
			return "signup";
		}
		return "redirect:/welcome";
	}

	@GetMapping("/sign-up")
	public String signUp(Authentication authentication) {
		if (authentication != null)
			return "redirect:/";
		return "signup";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest rq, Authentication authentication) {
		if (authentication != null)
			rq.getSession().invalidate();
		return "redirect:/sign-in";
	}
}
