package org.telbot.telran.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getId() == 0) {
            throw new IllegalArgumentException("You entered incorrect ID for user");
        }
        long userId = user.getId();
        User entity = userRepository.findById(userId).orElse(null);
        if (entity != null) {
            entity.setUserName(entity.getUserName());
            entity.setCurrentLastEventId(entity.getCurrentLastEventId());
            userRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.delete(getUser(id));
    }
}
