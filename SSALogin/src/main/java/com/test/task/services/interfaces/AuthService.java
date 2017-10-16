package com.test.task.services.interfaces;

import com.test.task.exceptions.BadRequestException;

import javax.servlet.http.HttpServletResponse;

public interface AuthService {
	void register(String login, String password) throws BadRequestException;

	void login(String login, String password, HttpServletResponse response);
}
