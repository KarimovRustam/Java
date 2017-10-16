package com.test.task.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@Configuration
public class AuthenticationProviderConfig {

	@Autowired
	private DataSource dataSource;

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource);
		jdbcImpl.setUsersByUsernameQuery("select login as username, password, true as enabled from \"user\" where login=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select login as username, role from \"user\" where login=?");
		return jdbcImpl;
	}

}
