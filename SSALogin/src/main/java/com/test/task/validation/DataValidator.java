package com.test.task.validation;

import com.test.task.dao.UsersDao;
import com.test.task.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataValidator {

	private static final String LOGIN_PATTERN = "^[a-zA-z0-9].{4,255}$";
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,255}$";

	@Autowired
	private UsersDao usersDao;

	public void validateLogin(String login) throws BadRequestException {
		if (login == null || !login.matches(LOGIN_PATTERN))
			throw new BadRequestException("Имя пользователя должно быть длиннее 4 символов и состоять из цифр и букв английского алфавита");
		if (usersDao.existsByLoginIgnoreCase(login))
			throw new BadRequestException("Пользователь с таким именем уже зарегистрирован");
	}

	public void validatePassword(String password) throws BadRequestException {
		if (password == null || !password.matches(PASSWORD_PATTERN))
			throw new BadRequestException("Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов");
	}
}
