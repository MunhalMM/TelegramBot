package org.telbot.telran.info.service;

import org.telbot.telran.info.model.User;

import java.util.List;

public interface UserService {

    List<User> listAllUser();

    User getUser(int id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(int id);
}
