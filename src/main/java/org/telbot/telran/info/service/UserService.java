package org.telbot.telran.info.service;

import org.telbot.telran.info.model.User;

import java.util.List;

/**
 * This is interface for abstracting business logic for the user entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 */
public interface UserService {
    /**
     * This abstract method for return list all users
     *
     * @return list all users from repository
     */
    List<User> listAllUser();

    /**
     * This abstract method for receiving user by id
     *
     * @param id user internal id
     * @return user entity from repository by id
     */
    User getUser(long id);

    /**
     * This abstract method for creating a new user entity
     *
     * @param user user entity
     * @return new user entity
     */
    User createUser(User user);

    /**
     * This abstract method for updating user entity
     *
     * @param user user entity from repository
     * @return updated user entity
     */
    User updateUser(User user);

    /**
     * This abstract method for deleting user entity by id
     *
     * @param id user internal id
     */
    void deleteUser(long id);
}
