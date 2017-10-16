package com.test.task.services.implementations;

import com.test.task.dao.UsersDao;
import com.test.task.exceptions.BadRequestException;
import com.test.task.models.User;
import com.test.task.services.interfaces.AuthService;
import com.test.task.validation.DataValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DataValidator dataValidator;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void register(String login, String password) throws BadRequestException {
		dataValidator.validateLogin(login);
		dataValidator.validatePassword(password);
		User user = User.builder()
				.login(login)
				.password(passwordEncoder.encode(password))
				.role("USER")
				.build();
		usersDao.save(user);
	}

	public void login(String login, String password, HttpServletResponse response) {
		UserDetails details = userDetailsService.loadUserByUsername(login);
		UsernamePasswordAuthenticationToken usernameAndPassword =
				new UsernamePasswordAuthenticationToken(
						login, password, details.getAuthorities());
		Authentication auth = authenticationManager.authenticate(usernameAndPassword);
		SecurityContextHolder.getContext().setAuthentication(auth);
		response.addCookie(new Cookie("login", login));
	}
}
