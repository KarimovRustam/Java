package net.helloworld.springsecurityapp.service;

import net.helloworld.springsecurityapp.model.User;



public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
