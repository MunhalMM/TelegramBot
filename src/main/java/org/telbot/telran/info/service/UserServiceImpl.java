package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;;

/**
 * This class to implement the business logic of user entity
 *
 * @author Munhal Mammadov
 * @version 1.0
 * @see UserService
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * Field for auto-binding a class with a user repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * This method returns the entire list of users from the repository
     *
     * @return list all users from reository
     */
    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    /**
     * This method returns a user from the repository by id
     *
     * @param id user internal id
     * @return entity user from repository
     * @throws IllegalArgumentException if internal user id is incorrect
     */
    @Override
    public User getUser(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Please enter correct id");
        }
        return userRepository.findById(id).orElse(null);
    }

    /**
     * This method for creating a new user entity
     *
     * @param user user entity
     * @return new user entity to repository
     * @throws IllegalArgumentException if fields for user entity filled out incorrectly
     */
    @Override
    public User createUser(User user) {
        if (user.getUserName().isEmpty() || userRepository.findById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("Please enter correct data");
        }
        return userRepository.save(user);
    }

    /**
     * This method for updating a user entity from repository
     *
     * @param user user entity from repository
     * @return updated user entity
     * @throws IllegalArgumentException if user id from repository incorrect
     */
    @Override
    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new IllegalArgumentException("You entered incorrect ID for user");
        }
        long userId = user.getId();
        User entity = userRepository.findById(userId).orElse(null);
        if (entity != null) {
            entity.setUserName(entity.getUserName());
            userRepository.save(entity);
        }
        return entity;
    }

    /**
     * This method for deleting a user from repository by id
     *
     * @param id user internal id
     * @throws IllegalArgumentException if entered incorrect id for user
     */
    @Override
    public void deleteUser(long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Please enter correct id for User");
        }
        userRepository.delete(getUser(id));
    }
}
