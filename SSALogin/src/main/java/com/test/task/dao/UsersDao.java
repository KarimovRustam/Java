package com.test.task.dao;

import com.test.task.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<User, Long> {
	boolean existsByLoginIgnoreCase(String login);
}
